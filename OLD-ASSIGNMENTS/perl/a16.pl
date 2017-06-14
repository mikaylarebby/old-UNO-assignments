#!/usr/bin/perl
use Modern::Perl;
use strict;
use warnings;

my $target = (int rand 100) + 1;  #generate random number
my ($g);
my ($guess);
my (@guesses);
print "Let's play a game.. Guess the number! Enter a number 0-100 to start!\n";
while ($g ne $target) {
    print "Guess: ";
    chomp( $g=<> );   
    if ($g eq $target) {
        last;
    }
    elsif ($g > 100 || $g < 0) {
        say "guess out of range, try again"
    }
    elsif ($g < $target) {
        print "too low, guesses so far: @guesses\n";
        push (@guesses,$g);
        $guess++;
    }
    elsif ($g > $target) {
    print "too high, guesses so far: @guesses\n";
    push (@guesses,$g);
    $guess++; 
}
}
if ($g eq $target) {
    print "\nCorrect!\n";
    print "It only took you $guess guesses!\n";
}
