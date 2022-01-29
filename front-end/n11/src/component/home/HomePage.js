import React from "react";
import { Button, Table } from 'react-bootstrap/';
class HomePage extends React.Component {

    render() {
        return (
            <div className="container">
                <div className="text-center mt-5">
                    <Button variant="primary" href="/user/add">AddUserPage</Button>
                </div>
            </div>
        )
    }
}

export default HomePage;