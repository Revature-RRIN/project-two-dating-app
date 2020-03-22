import { Component, OnInit } from '@angular/core';
import { Users } from '../shared/classes/users';
import { Router, ActivatedRoute } from "@angular/router";
import { ProfileService } from 'src/app/shared/services/createprofile.service';
import { Currentuser } from '../shared/classes/currentuser';
import { UsersService } from '../shared/services/users.service';
// import * as AWS from 'aws-sdk';  //CAUSING A BUNCH OF ERRORS... WHY???

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  users: Users;
  constructor(private router: Router,
    private route: ActivatedRoute,
    private profile: ProfileService,
    private us : UsersService
    ) { }

    image : any;
    AWS: any;

  ngOnInit(): void {
    
    
    this.users = this.us.getUser(); //NEED ANYWHERE THE LOGGED-IN USER IS REFERRED TO...EVERYWHERE!!!
    
  }

  updateProfile() {
    this.profile.updateProfile(this.users).subscribe(
      users => {
        this.users = users;
        this.router.navigate(["questions"])
      }
    );
  

   }

   fileEvent(fileInput: any) {
    const AWSService = this.AWS;
    const region = '<us-east>';
    const bucketName = '<lc-profile-bucket>';
    const IdentityPoolId = '<us-east-1_8998734hk>';
    const file = fileInput.target.files[0];
  
    AWSService.config.update({
      region: region,
      credentials: new AWSService.CognitoIdentityCredentials({
        IdentityPoolId: IdentityPoolId
      })
    });
  
    const s3 = new AWSService.S3({
      apiVersion: '2006-03-01', //??
      params: { Bucket: bucketName}
    });
  
    this.image = file.name;
    s3.upload({ Key: file.name, Bucket: bucketName, Body: file, ACL: 'public-read'}, function (err, data) {
     if (err) {
       console.log(err, 'there was an error uploading your file');
     }
   });
  }
}

