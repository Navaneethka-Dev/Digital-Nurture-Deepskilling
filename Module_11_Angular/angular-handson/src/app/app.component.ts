import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: []
})
export class AppComponent {
  title = 'Angular Hands-On';
  modules = [
    { title: 'Components and Directives', desc: 'Understanding the building blocks of Angular UI' },
    { title: 'Data Binding & Pipes', desc: 'Property binding, event binding, two-way binding, and data formatting' },
    { title: 'Services & Dependency Injection', desc: 'Sharing logic across components effectively' },
    { title: 'Routing & Navigation', desc: 'Implementing a Single Page Application navigation structure' },
    { title: 'Forms (Template-driven & Reactive)', desc: 'Managing user inputs and validations' },
    { title: 'HTTP Client & Observables', desc: 'Fetching data from REST APIs using RxJS' }
  ];
}
