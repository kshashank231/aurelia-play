import { Employee } from "./employee";
import { HttpClient, json } from "aurelia-fetch-client";
import { inject } from "aurelia-framework";
import { Router } from "aurelia-router";

let httpClient = new HttpClient();

@inject(Router)
export class AddEmployee {
  constructor(router) {
    this.router = router;
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
    }
  }

  postData(myPostData) {
    httpClient
      .fetch("http://localhost:9000/api/employee/post", {
        method: "POST",
        body: JSON.stringify(myPostData),
      })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        this.employeeId = "";
        this.employeeName = "";
        this.employeeEmail = "";
        this.employeePhone = "";
        this.router.navigateToRoute("home");
      });
  }
}
