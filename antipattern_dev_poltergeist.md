Anti-Pattern: Poltergeist
===================

Name     | Value
-------- | ---
Anti-Pattern Name | Poltergeist
Andere Namen      | Gypsy, Proliferation of Classes, and Big DoIt Controller
Kategorie | Software Development
Anekdote    | "Ich bin mir nicht ganz sicher, was diese Klasse genau macht, aber sie ist sicher wichtig!"

Kurzzusammenfassung
-------------------
Poltergeist-Klassen sind Klassen, die erstellt werden eine Aufgabe erledigen und danach sofort weider verschwinden. Meistens erstellen sie ein anderes Objekt welches über eine längere Laufzeit verfügt. Sie sind eigemtlich unnötig und verschwenden Resourcen. Zusätzlich verwirren sie.

Erscheinungsform
----------------
- Klassen mit limitierter Verantwotung und Rolle für das Gesamtsystem
- sehr kurze Lebenszeit
- verwirren das Designing der Software und erschweren das Verstehen und warten

Symptome
--------
- der eigentliche Sinn der Klasse ist relativ unklar
- kurzlebige Objekte
- es existieren Klassen, welche einzige Aufgabe es ist ander Objekte zu ertellen
- Klassen mit "control-like" Namen ("start_process_alpha")

Ursachen
--------
- fehlendes Verständnis für objektorientiertes Design
- Objekt-Orientierung nicht das richtige Mittel für dieses Problem
- schlecht/unpassend definierte Anforderungen

Konsequenzen
------------
- zustandslode Klassen
- auftauchende und schnell wieder verschwindende Objekte
- unnötige Resourcenverschwendung
- unnötig unverständliche OO Struktur

Lösung / Refactoring
--------------------
- diese Klassen entfenen
- funktionaltität in erstellte Klasse verschieben