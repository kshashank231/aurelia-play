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
    return this.getData();
  }

  getData() {
    httpClient
      .fetch("http://localhost:9000/api/employee/get")
      .then((response) => response.json())
      .then((data) => {
        this.employees = data;
      });
  }

  delete(id) {
    console.log(id);
    httpClient
      .fetch("http://localhost:9000/api/employee/delete/" + id, {
        method: "DELETE",
      })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        this.getData();
      })
      .catch((err) => console.log(err));
  }
}
