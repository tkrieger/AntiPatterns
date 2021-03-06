Anti-Pattern: The Blob
===================

Name     | Value
-------- | ---
Anti-Pattern Name | The Blob 
Andere Namen      | Winnebago, The God Class
Kategorie | Software Development
Anekdote    | "Diese Klasse ist das *Herz* unserer Anwendung"

Kurzzusammenfassung
-------------------
Ein Blob Element bezeichnet eine zu "mächtige" Klasse. Die Klasse trägt sozusagen zu viel Verantwortung im Programm, da in ihr quasi jegliche Funktionalität implementiert ist. Sprich dieses Objekt "weiß und macht" einfach zu viel. Andere Klassen und Objekte werden fast ausschließlich nur als Datenspeicher verwendet. Dies widerspricht grundlegend dem objektorientierten Ansatz.

Erscheinungsform
----------------
- andere Klassen dienen fast ausschließlich als Datenspeicher
- jegliche Funktionaltiät wird meist von dieser Klasse bereitgestellt
- entspricht einem prozeduralen Entwurf, auch wenn in Klassen "verpackt" ( Trennung von Daten & Funktionalität vs. Mischung dieser)

Symptome
--------
- Haufenweise Attribute und Methoden in einer Klasse (>60)
- Verschiedene Attribute und auch Methoden stehen in keinem Zusammenhang
- sonstigen Klassen verfügen über kaum Logik

Ursachen
--------
- fehlendes Verständnis für objektorientiertes Design
- fehlen einer definierten Architektur: (keine Systemkomponenten, Schnittstellen usw.)
- mangelde Durchsetzung einer def. Architektur: (zu wenig Kontrolle dieser während dev. Prozess)
- zu kleines Eingreifen bei Veränderung: (Entwickler fügen lieber kleine Stücke zu existierenden Klassen hinzu)
- schlecht/unpassend definierte Anforderungen

Konsequenzen
------------
- Einschränkung der Modifizierbarkeit (-> Data Encapsulation / Abhägigkeiten von Daten)
- Blob Klassen sind zu komplex zur Wiederverwendung
- gute Tests sind sehr schwer zu erstellen
- imenser Resourcen verbrauch (->kritisch bspw. bei Java-Class-Loading)

Lösung / Refactoring
--------------------
- Schlüssel: Verhalten von Blob Klasse in andere auslagern. Eventuell zu den bereits bestehenden Datenobjekten:
1. identifizieren und kategorisieren von Attributen und Methoden mit Zusammenhang
2. eigentliches Klasse für diese Attribut suchen (oder neu entwerfen)
3. ... -> Umziehen, dabei bestehende Beziehungen überprüfen und ggf. auch ändern usw.