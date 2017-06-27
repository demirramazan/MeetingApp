import React from 'react';
import axios from 'axios';
import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table';

var Employees = React.createClass({

    getInitialState: function() {

        return {
            tableData: null,
            departments: null,
        }
    },

    componentDidMount: function() {
        this.allEmployess();
    },

    render: function() {

        if(!this.state.tableData){
            return (<div></div>);
        }

        return (
            <div>

                <BootstrapTable data={this.state.tableData}>
                    <TableHeaderColumn dataField="id" isKey={true} >ID</TableHeaderColumn>
                    <TableHeaderColumn dataField="name">Name</TableHeaderColumn>
                    <TableHeaderColumn dataField="surname">Surname</TableHeaderColumn>
                    <TableHeaderColumn dataField="salary">Salary</TableHeaderColumn>
                    <TableHeaderColumn dataField="departmentId" dataFormat={this.departmentName}>Department</TableHeaderColumn>
                </BootstrapTable>

            </div>
        );
    },


    departmentName: function(cell, row) {
        return this.getDepartmentName(row.departmentId);
    },

    getDepartmentName: function(departmentId) {

        for(var i in this.state.departments) {
            if(this.state.departments[i].id === departmentId) {
                return this.state.departments[i].name;
            }
        }
        return '';
    },



    getEmployees: function() {
        return axios.get('http://localhost:8085/employee/employees');
    },

    getDepartments: function() {
        return axios.get('http://localhost:8085/departments');
    },

    allEmployess: function() {

        axios.all([this.getEmployees(), this.getDepartments()])
            .then(axios.spread(function (employees, departments) {
                this.setState({tableData: employees.data,
                    departments: departments.data});
            }.bind(this)));
    }
});

export default Employees;
