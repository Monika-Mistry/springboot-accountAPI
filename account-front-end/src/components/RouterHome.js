import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Axios from 'axios';

import NavBar from './NavBar';
import Home from './Home';
import RegisterForm from './RegisterForm';
import { postURL, getURL } from './Constants';
import AccountList from './AccountList';

export default class RouterHome extends Component {
    constructor() {
        super();
        this.state = {
            account: {},
            isShown: false,
            allAccounts: []

        }
    }

    getAll = () => {
        Axios.get(getURL)
            .then(response => {
                this.setState({
                    allAccounts: response.data
                })
            })
            .catch(err => console.log(err))

    }

    createAccout = event => {
        event.preventDefault();

        const account = {
            firstName: event.target[0].value,
            lastName: event.target[1].value
        }

        Axios.post(postURL, account)
            .then(response => {
                this.setState({
                    account: response.data,
                    isShown: true
                })
            })
            .catch(err => console.log(err));
    }

    toggle = () => {
        this.setState({
            account: {},
            isShown: false
        })
    }


    render() {
        return (
            <Router>
                <NavBar />
                <br />

                <Route exact path="/" component={Home} />
                <Route
                    path="/register"
                    render={props => <RegisterForm
                        createAccount={this.createAccout}
                        account={this.state.account}
                        isShown={this.state.isShown}
                        toggle={this.toggle} />}
                />
                <Route path="/accounts" render={props => <AccountList
                    accounts={this.state.allAccounts}
                    getAll={this.getAll} />} />

            </Router>
        )
    }
}