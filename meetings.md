Protokoll der Arbeiten
======================


Der Protokollant ist in der Anwesenheitsliste *hervorgehoben*.


Sitzung am 21.04.2016
---------------------

Anwesend: Simon, Leander, *Klaus*, Matthias, oki, Daniel, Oskar

 - Netzwerkbasiertes Monopoly mit optionaler Chatmöglichkeit
 - Teamspeak 3 als Austauschplattform außerhalb der Schule
 - Bedeutung der Project Board-Karten:

   Farbe | Typ       | Bedeutung
   ------|-----------|-------
   Rot   | Userstory | Funktion
   Grün  | Userstory | Design
   Blau  | Task      | Funktion
   Gelb  | Task      | Design

 - Entwicklungsumgebung: Eclipse :/
 
Sitzung am 25.04.2016
---------------------

Anwesend: Simon, Leander, *Klaus*, Matthias, Oskar, oki, Daniel

 - E-Mails ausgetauscht
 - Teamspeak-Server wird von Matthias bereitgestellt
 - Das Token ist ineffizient und wird nicht mehr verwendet
 - WhatsApp-Gruppe für alle außer oki
 - Vorbereitung der ersten User-Stories
   * Easter-Egg: Comic Sans MS für jedem Straßennamen verwenden
   * Umsetzung mit MVC

Sitzung am 28.04.2016
---------------------

Anwesend: Simon, Leander, *Klaus*, Matthias, Oskar, oki, Daniel

 - Wir übernehmen die Regeln von Monopoly Deutschland.
 - Währung: REICHSmark
 - Name: MPMP
 - Layout wird von Klaus in Gimp erstellt.

Außerschulisches Arbeiten am 06.05.2016
---------------------------------------

Anwesend: Oskar, *Leander*

 - Vervollständigung des Regelwerks in der Datei rules.md.

Sitzung am 09.05.2016
---------------------

Anwesend: Matthias, Oskar, *oki*, Daniel

 - Eclipse muss erst installiert und demonstriert werden.
 - Ein paar Mouse-Events wurden ausprobiert in einem kleinen Zähler-Programm.
 - Eclipse ist dem Protokollant nach die falsche Wahl.

Sitzung am 12.05.2016
---------------------

Anwesend: Leander, *Klaus*, Matthias, oki, Daniel

 - Leander und oki erstellen das Eclipse-Projekt und machen eine Chatbox.
 - Klaus und Matthias kreieren SVG-Grafiken.
 - Dani recherchiert zuerst Straßennamen und hilft dann beim Coding.
 
Außerschulisches Arbeiten am 16.05.2016
---------------------------------------

Anwesend: *Leander*, oki

 - Protokolldesign grob fertig (→ [proto.md](proto.md))
 - Servergerüst erstellt
 
Außerschulisches Arbeiten am 21.05.2016
---------------------------------------

Anwesend: *Leander*, oki

 - Server, der beliebig viele Verbindungen aufnehmen kann und allen Clients dieselbe Nachricht schickt.

Hardcore-Arbeitsphase vom 30.05.-02.06.2016
-------------------------------------------

 - Protokoll teilweise fertig
 - Server implementiert dieses teilweise; das Hinzufügen von Befehlen ist sehr einfach
 - Client und Server sharen den Protokollcode
 - einige weitere Grafiken fertig, der Client kann jedoch noch nichts
 - Funktion 'subscribe' hinzugefügt
 - Funktion 'listp' hinzugefügt
 - Funktion 'listp' entfernt, weil sie niemand braucht

Außerschulisches Arbeiten am 04.06.2016
---------------------------------------

Anwesend: *oki*, Leander

 - Versuch, den bei Client und Server gleichen Netzwerkteil in eine Lib zu stecken.
   Dieser Versuch scheitert, weil Cmd ein enum ist und sein muss. Da jedoch Client
   und Server verschiedene Messages haben, sollten sie Cmd extenden. Enums können
   aber nicht extended werden. Die Alternativen sind relativ *meh* und deswegen muss
   der Ansatz noch überdacht werden.

Sitzung am 09.06.2016
---------------------

Anwesend: *oki*, Leander, Klaus, Daniel, Oskar, Simon

 - Die Entwicklungsumgebung ist seit dem 06.06.2016 NetBeans. Die Umstellung
   war einfach.
 - Klaus und oki arbeiten am Launcher, redesigned das Interface.
 - Dani macht das Benutzerhandbuch.
 - Oskar versucht, in einem Testprojekt Soundeffekte abzuspielen.
 - Leander, Simon und oki bringen den Client weiter, sodass er Chat senden und
   empfangen kann. Auch das Subscriben beim Programmstart wurde umgesetzt.
 - Matthias arbeitet an einem Code zum Auslesen und verarbeiten der Gesellschafts- und Ereigniskarten.

Sitzung am 13.06.2016
---------------------

Anwesend: *oki*, Leander, Klaus, Daniel, Oskar, Simon, Matthias

 - Leander implementiert das `end-turn`-Paket.
 - Matthias zeigt oki seinen bisherigen Code zum Einlesen der Ereigniskarten.
 - Dani und Simon arbeiten weiter am Handbuch.
 - Klaus und Oskar arbeiten jeweils an Grafik- und Sound-Integration.

Sitzung am 16.06.2016
---------------------

Anwesend: *oki*, Leander, Klaus, Daniel, Oskar, Simon, Matthias

 - Leander und oki versuchen, eine `model.Player`-Klasse zu machen, die
   aber keinen Namen speichern soll, sonst würde ja die Info in `main.Client`
   doppelt gespeichert werden. Problem: Zuschauer haben auch einen Namen, sind
   aber keine Spieler. okis Lösung am selben Abend: einfach alles in `Player`
   rein; auch Spectators sind `Player`s; nichts darf in `Client` gespeichert
   werden, da diese Klasse nur auf dem Server benutzt wird.
 - Klaus klatscht alle SVGs zu ener großen Spielfeld-SVG zusammen. Komplex.

Sitzung am 20.06.2016
---------------------

Anwesend: *oki*, Leander, Klaus, Daniel, Oskar, Simon, Matthias

 - Matthias erstellt eine Liste der von den Ereigniskarten benötigten Methoden.
 - Klaus hat nun ein Testprojekt eingefügt (`mpmp-client`), das das Hintergrundbild
   zeichnet und die SVG richtig darauf einfügt. Problem: die SVG skaliert nicht
   automatisch. Wahrscheinlich muss eine Transform-Methode von *Butt-kick* (lt. Klaus)
   aufgerufen werden.
 - Simon, Leander und oki implementieren das Protokollfehlersystem (PR #20) zuende.
   Die Race-Condition im Networking-Code wird am selben Tag gelöst (Issue #31).
 - Dani ist im Regeldetailbereich des Handbuchs; die Arbeit stockt, weil die Regeln
   nicht genau genug sind (Issue #27).
