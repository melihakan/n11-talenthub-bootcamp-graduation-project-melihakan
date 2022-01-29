import { Route, Routes } from 'react-router-dom';
import './App.css';

import React from 'react';
import AddUserPage from './component/user/adduser/AddUserPage';
import HomePage from './component/home/HomePage';



class App extends React.Component {

  render() {

    return (
      <div className="App">

        <Routes>
          <Route path="/user/add" element={<AddUserPage/>}></Route>
          <Route path="/" element={<HomePage/>}></Route>
        </Routes>

      </div>
    );
  }

}

export default App;
