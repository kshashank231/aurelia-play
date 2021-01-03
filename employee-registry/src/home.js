import { HttpClient, json } from "aurelia-fetch-client";

let httpClient = new HttpClient();

export class Home {
  constructor() {
    this.employees = [];

    this.employeeId = "";
    this.employeeName = "";
    this.employeeEmail = "";
    this.employeePhone = "";
  }

  created() {
    httpClient
      .fetch("http://localhost:9000/api/employee")
      .then((response) => response.json())
      .then((data) => {
        this.employees = data;
      });
  }
}
