import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <table>
            <tr>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Employee Surname</th>
                <th>Employee Salary</th>
                <th>Department</th>
            </tr>
            <tr>
                <td>1</td>
                <td>"Ramazan"</td>
                <td>"Demir"</td>
                <td>3200</td>
                <td>"Sofware Engineering"</td>
            </tr>
        </table>
      </div>
    );
  }
}

export default App;
