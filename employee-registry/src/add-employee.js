import { Employee } from "./employee";
import { HttpClient, json } from "aurelia-fetch-client";

let httpClient = new HttpClient();

export class AddEmployee {
  constructor() {
    this.heading = "Add New Employee";
    this.employeeId = "";
    this.employeeName = "";
    this.employeeEmail = "";
    this.employeePhone = "";
  }

  addEmployee() {
    if (
      this.employeeId &&
      this.employeeName &&
      this.employeeEmail &&
      this.employeePhone
    ) {
      const newEmp = new Employee(
        this.employeeId,
        this.employeeName,
        this.employeeEmail,
        this.employeePhone
      );
      this.postData(newEmp);
      this.employeeId = "";
      this.employeeName = "";
      this.employeeEmail = "";
      this.employeePhone = "";
    }
  }

  postData(myPostData) {
    httpClient
      .fetch("http://localhost:9000/api/employee/create", {
        method: "POST",
        body: JSON.stringify(myPostData),
      })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
      });
  }
}
