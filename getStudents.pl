#!/usr/bin/perl
use strict;
use warnings;
use JSON::Parse 'parse_json';
use LWP::UserAgent;
use Data::Dumper; # just for output

my $auth = "1030~SADsjosSBByiXvQBcimKrXILcNrl8jNt1snMDh9owY9PX2cItHPLJUBp988sExqI";
#my $accountid = "10300000000000133";
my $curl = "curl -H 'Authorization: Bearer $auth'";
#system("curl -H 'Authorization: Bearer $auth' https://canvas.instructure.com/api/v1/courses");
#system("curl -H 'Authorization: Bearer $auth' https://canvas.instructure.com/api/v1/accounts/$accountid/analytics/current/grades");


system("$curl https://canvas.instructure.com/api/v1/courses/10300000000000133 -X PUT -d 'end_at=2017-05-28T04:00:00Z' ");

    my $json = '["golden", "fleece"]';
    my $perl = parse_json ($json);




    # Same effect as $perl = ['golden', 'fleece'];
#system("$curl https://canvas.instructure.com/api/v1/courses/:course_id/recent_students ");

#/api/v1/audit/course/courses/:course_id 