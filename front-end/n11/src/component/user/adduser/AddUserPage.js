import React from "react";
import PageTitle from "../../gen/PageTitle";
import serialize from 'form-serialize';
import { Navbar,  Nav, NavDropdown, Button } from 'react-bootstrap/';

class AddUserPage extends React.Component {

    state = {
        user: {}
    }

    handleFormSubmit = (e) => {
        e.preventDefault();
        const newUser = serialize(e.target, { hash: true })

        this.save(newUser);

    }
    save(newUser) {

        const requestOptions = {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newUser)
        }

        fetch('http://localhost:8080/api/v1/users', requestOptions)
            .then(response => response.json())
            .then(data => {
                console.log("data geldi")
                console.log(data)
                this.setState({ user: data })

                if (data.id) {
                    this.clearForm();
                }

            })
            ;

    }

    handleResponse(response) {
    }

    handleError(error) {
        console.log(error.data);
    }

    clearForm() {
        document.getElementById("user-form").reset();
    }

    render() {
        return (

            <div className="container col-md-6 offset-md-3">

                <PageTitle title="User Add Page"></PageTitle>
                <Button variant="primary" href="/">HomePage</Button>
                <form id="user-form" className="mt-5" onSubmit={this.handleFormSubmit}>
                    
                    
                    <div className="form-row">

                        <div className="form-group">
                            <label htmlFor="inputName">TC</label>
                            <input type="text"
                                className="form-control"

                                name="tc" />
                        </div>

                        <div className="form-group">
                            <label htmlFor="inputName">Name</label>
                            <input type="text"
                                className="form-control"

                                name="name" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="inputName">Surname</label>
                            <input type="text"
                                className="form-control"

                                name="surName" />
                        </div>

                        <div className="form-group">
                            <label htmlFor="inputRating">Salary</label>
                            <input type="number"
                                className="form-control"

                                name="salary" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="inputName">Phone Number</label>
                            <input type="text"
                                className="form-control"

                                name="phoneNumber" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="inputName">Birthday</label>
                            <input type="text"
                                className="form-control"

                                name="birthday" />
                        </div>

                        <div className="form-group">
                            <label htmlFor="inputRating">Assurance</label>
                            <input type="number"
                                className="form-control"

                                name="assurance" />
                        </div>

                    </div>

                    <input type="submit" className="btn btn-danger btn-block" value="Kaydet" />
                </form>
            </div>
        )
    }
}
export default AddUserPage;