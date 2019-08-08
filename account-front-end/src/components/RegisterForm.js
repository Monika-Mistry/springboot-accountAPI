import React from 'react';
import {
    Form,
    FormGroup,
    Label,
    Input,
    Col,
    Button,
    Modal,
    ModalBody,
    ModalHeader,
    ModalFooter
} from 'reactstrap';

export default function RegisterForm(props) {
    return (
        <div>
            <Form className="container" onSubmit={props.createAccount}>
                <FormGroup row>
                    <Label for="firstName" sm={2}>First Name:</Label>
                    <Col sm={10}>
                        <Input
                            required
                            type="text"
                            name="firstName"
                            id="firstName"
                            placeholder="First Name"
                        />
                    </Col>
                </FormGroup>
                <FormGroup row>
                    <Label for="lastName" sm={2}>Last Name:</Label>
                    <Col sm={10}>
                        <Input
                            required
                            type="text"
                            name="lastName"
                            id="lastName"
                            placeholder="Last Name"
                        />
                    </Col>
                </FormGroup>
                <div className="text-center">
                    <Button>Register</Button>
                </div>
            </Form>
            <br />
            <br />
            <Modal isOpen={props.isShown} toggle={props.toggle}>
                <ModalHeader>Your Account Details</ModalHeader>
                <ModalBody>
                    <h4>First Name</h4>
                    <p className="text-success">{props.account.firstName}</p>
                    <h4>Last Name</h4>
                    <p className="text-success">{props.account.lastName}</p>
                    <h4>Account Number</h4>
                    <p className="text-success">{props.account.accountNumber}</p>
                    <h4>Prize</h4>
                    <p className="text-success">{props.account.prize}</p>
                </ModalBody>
                <ModalFooter>
                    <Button onClick={props.toggle}>Dismiss</Button>
                </ModalFooter>
            </Modal>
        </div>
    )
}