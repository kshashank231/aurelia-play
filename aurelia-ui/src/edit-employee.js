import { Employee } from "./employee";
import { HttpClient, json } from "aurelia-fetch-client";
import { inject } from "aurelia-framework";
import { Router } from "aurelia-router";

let httpClient = new HttpClient();

@inject(Router)
export class EditEmployee {
  constructor(router) {
    this.router = router;
    this.heading = "Edit Employee";
    this.employeeId = "";
    this.employeeName = "";
    this.employeeEmail = "";
    this.employeePhone = "";
  }

  activate(params, routeConfig) {
    this.routeConfig = routeConfig;

    this.getEmployee(params.id);
  }

  getEmployee(id) {
    httpClient
      .fetch("http://localhost:9000/api/employee/get/" + id)
      .then((response) => response.json())
      .then((data) => {
        this.employeeId = data.eid;
        this.employeeName = data.name;
        this.employeeEmail = data.email;
        this.employeePhone = data.phone;
      });
  }

  editEmployee() {
    if (this.employeeName && this.employeeEmail && this.employeePhone) {
      const newEmp = new Employee(
        this.employeeId,
        this.employeeName,
        this.employeeEmail,
        this.employeePhone
      );
      this.updateData(newEmp);
    }
  }

  updateData(newData) {
    httpClient
      .fetch("http://localhost:9000/api/employee/put/" + this.employeeId, {
        method: "PUT",
        body: JSON.stringify(newData),
      })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        this.employeeName = "";
        this.employeeEmail = "";
        this.employeePhone = "";

        this.router.navigateToRoute("home");
      });
  }
}
