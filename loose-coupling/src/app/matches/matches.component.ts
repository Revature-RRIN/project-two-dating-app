import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Users } from '../shared/classes/users';
import { Router, ActivatedRoute } from '@angular/router';
import { MatchesService } from '../shared/services/matches.service';
import { UsersService } from '../shared/services/users.service';
import { Matches } from '../shared/classes/matches';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {
  matches:Matches[];
  users: Users;
  @Output() submitted = new EventEmitter<Users>();

  constructor(private router: Router,
    private route: ActivatedRoute,
    private match: MatchesService,
    private us : UsersService) { }

  ngOnInit(): void {
    this.users = this.us.getUser();
    console.log(this.users);
    this.match.getMatches().subscribe(
      matches => {
        this.matches = matches;
      }
    );
  }

}
