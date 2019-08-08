import React, { Component } from 'react';
import { Table } from 'reactstrap';

import Account from './Account';

export default class AccountList extends Component {
    componentDidMount() {
        this.props.getAll();
    }

    render() {
        return (
            <div className="container" >
                <Table>
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Account Number</th>
                            <th>Prize</th>
                        </tr>
                    </thead>
                    <Account accounts={this.props.accounts} />
                </Table>
            </div>

        )
    }
}