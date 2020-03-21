import { Component, OnInit } from '@angular/core';
import { Users } from '../shared/classes/users';
import { Router, ActivatedRoute } from '@angular/router';
import { MatchesService } from '../shared/services/matches.service';
import { UsersService } from '../shared/services/users.service';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {
  users: Users;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private match: MatchesService,
    private us : UsersService) { }

  ngOnInit(): void {
    this.users = this.us.getUser();
    this.match.getMatches().subscribe(
      matches => {
        this.match = matches;
      }
    );
  }

}
