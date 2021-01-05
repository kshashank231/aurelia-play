import { PLATFORM } from "aurelia-pal";

export class App {
  constructor() {
    this.heading = "EMPLOYEE REGISTRY";
  }

  configureRouter(config, router) {
    this.router = router;
    config.title = "Employee Registry";

    config.map([
      {
        route: "",
        moduleId: PLATFORM.moduleName("home"),
        name: "home",
        title: "Home",
      },
      {
        route: "add-employee",
        moduleId: PLATFORM.moduleName("add-employee"),
        name: "add-employee",
        title: "Add Employee Details",
      },
      {
        route: "edit-employee/:id",
        moduleId: PLATFORM.moduleName("edit-employee"),
        name: "edit-employee",
        title: "Edit Employee Details",
      },
    ]);
  }
}
