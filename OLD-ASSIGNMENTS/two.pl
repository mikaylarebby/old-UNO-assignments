


       
                                     
use strict;
use warnings;

my $dollars;
my $cents = 56;
my $name = "Mikayla";

my $dollarsAndCents;

print "Please enter the number of dollars: ";
chomp ( $dollars = <> );
print "There are $dollars dollars and $cents cents.\n";

$dollarsAndCents = ( $dollars * 100 ) + $cents;

print "There are $dollarsAndCents total cents.\n";

print "Congratulations, $name, your second Perl program";
print " ran!\n\n";
