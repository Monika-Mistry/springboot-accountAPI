import React, { Component } from 'react';
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink
} from 'reactstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
    faUser,
    faList
} from '@fortawesome/free-solid-svg-icons';
import { NavLink as RRNavLink } from 'react-router-dom';

export default class NavBar extends Component {
    constructor() {
        super();
        this.state = {
            isOpen: false
        };
    }

    toggle = () => {
        this.setState(prevState => ({ isOpen: !prevState.isOpen }))
    }

    render() {
        return (
            <Navbar color="dark" dark expand="md">
                <NavbarBrand tag={RRNavLink} to="/">Banking Application</NavbarBrand>
                <NavbarToggler onClick={this.toggle} />
                <Collapse isOpen={this.state.isOpen} navbar>
                    <Nav className="ml-auto" navbar>
                        <NavItem>
                            <NavLink tag={RRNavLink} to="/register"><FontAwesomeIcon icon={faUser} /> Register</NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink tag={RRNavLink} to="/accounts"><FontAwesomeIcon icon={faList} /> Accounts</NavLink>
                        </NavItem>
                    </Nav>
                </Collapse>
            </Navbar>
        )
    }
}