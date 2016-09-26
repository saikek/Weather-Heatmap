clear
reset

set palette defined (-50 "blue",-40 "#00ffff", -30 "white", -20 "yellow", 10 "red",20 "#990000",30 "grey")

set terminal png truecolor nocrop enhanced font arial 12 size 1000,400

set xrange [0.5:30.5]
set yrange [-0.5:12]
set cbrange [-15:35]

unset key

set xtics 1
set ytics ("Jan" 11, "Feb" 10, "Mar" 9, "Apr" 8, "May" 7, "Jun" 6, "Jul" 5, "Aug" 4, "Sep" 3, "Oct" 2, "Nov" 1, "Dec" 0)

set rmargin screen 0.9
set tmargin screen 0.9
set bmargin screen 0.1

cd "F:/DEV Weather/res/"

do for [year=1998:2014] {

outoutFileName = sprintf('%4.0f.png',year)
set output outoutFileName

titleYear = sprintf('%4.0f',year)
set title titleYear

inFileName = sprintf('%4.0f.txt',year)
plot inFileName matrix with image
}

set output './dummy.dat'

################################################MULTIPLOT?

clear
reset

set palette defined (-50 "blue",-40 "#00ffff", -30 "white", -20 "yellow", 10 "red",20 "#990000",30 "grey")

set terminal png truecolor nocrop enhanced font arial 12 size 1000,400

set xrange [0.5:30.5]
set yrange [-0.5:12]
set cbrange [-20:35]

unset key
unset tics
unset grid
unset colorbox


#set lmargin screen 0.1
#set rmargin screen 0.9
#set tmargin screen 0.9
#set bmargin screen 0.1

cd "F:/DEV Weather/res/"

set output "allYears.png"
set multiplot layout 4,4

do for [year=1998:2013] {
inFileName = sprintf('%4.0f.txt',year)
plot inFileName matrix with image
}

unset multiplot

set output './dummy.dat'