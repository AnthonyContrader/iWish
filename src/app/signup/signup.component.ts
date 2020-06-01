import { Component, OnInit, ViewChild, ElementRef, Input } from '@angular/core';
import { UserDTO } from '../../dto/userdto';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import {UserService} from '../../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {


  inputType: string = "password"
  user: UserDTO = new UserDTO();
  registerForm: FormGroup;
  min_length_password = 8;
  regexp = new RegExp(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
  submitted: boolean = false;
  


  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router  ) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      login: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(this.min_length_password)]],
      psw_confirm: ['', [Validators.required, Validators.minLength(this.min_length_password)]]
    });
  }

  onSubmit() {
    this.submitted = true;
   

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }
  
    if(this.registerForm.value.password !== this.registerForm.value.psw_confirm){
      alert("Password is not the same!!");
      return;
    }
    this.user = new UserDTO(this.registerForm.value.login, this.registerForm.value.firstName, this.registerForm.value.lastName,
                           this.registerForm.value.email, this.registerForm.value.password, ['ROLE_USER'], new Date(), new Date(), false);
    this.userService.register(this.user).subscribe(()=>{
      alert('Check your Email for the Account Activation!');
      this.router.navigate(['/login']);
  
    });

  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  toggle() {
    if(this.inputType==="password"){
      this.inputType = "text";
    }
    else{
      this.inputType = "password";
    }
    
  }





}
