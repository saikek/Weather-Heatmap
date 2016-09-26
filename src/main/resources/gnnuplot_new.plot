clear
reset

set palette defined (-50 "blue",-40 "#00ffff", -30 "white", -20 "yellow", 10 "red",20 "#990000",30 "grey")

set terminal png truecolor nocrop enhanced font arial 12 size 1000,400

set xrange [0.5:30.5]
set yrange [-0.5:12]

unset key

set xtics 1
set ytics ("Jan" 11, "Feb" 10, "Mar" 9, "Apr" 8, "May" 7, "Jun" 6, "Jul" 5, "Aug" 4, "Sep" 3, "Oct" 2, "Nov" 1, "Dec" 0)

#set border linewidth 0
#unset colorbox - colors on right side of screen
#unset tics
#set lmargin screen 0.1
set rmargin screen 0.9
set tmargin screen 0.9
set bmargin screen 0.1

cd "F:/DEV Weather/res/"

set output './2013.png'

set title "2013"
plot '2013.txt' matrix with image

set output './dummy.dat'

#----------------------




clear
reset

set xrange [0:*]
set yrange [0:*]

set palette defined (0 "green", 30 "yellow", 60 "orange", 100 "red")

cd "F:/DEV Weather/parsed/"

unset key
unset xtics
unset ytics
#unset tics
#unset colorbox
#set border linewidth 0

set terminal png truecolor nocrop enhanced font arial 12 size 1000,1000

set output './managed1_r.png'
plot 'managed1_transposed_splitted_r.txt' matrix with image
set output './dummy.dat'


################################################
#One year - one line:

clear
reset

set palette defined (-50 "blue",-40 "#00ffff", -30 "white", -20 "yellow", 10 "red",20 "#990000",30 "grey")

set terminal png truecolor nocrop enhanced font arial 12 size 2000,350

set xrange [0.5:365.5]
set yrange [0.5:13.5]

set view map
unset key

#unset ytics
#unset xtics
set ytics ("1998" 15, "1998" 14, "1999" 13, "2000" 12, "2001" 11, "2002" 10, "2003" 9, "2004" 8, "2005" 7, "2006" 6, "2007" 5, "2008" 4, "2009" 3, "2010" 2, "2011" 1, "2013" 0)

#set border linewidth 0
#unset colorbox - colors on right side of screen
#unset tics
#set lmargin screen 0.1
set rmargin screen 0.9
set tmargin screen 0.9
set bmargin screen 0.1

cd "F:/DEV Weather/res2/"

set output './all.png'

plot 'all.txt' matrix with image

set output './dummy.dat'



