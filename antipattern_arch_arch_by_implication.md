Anti-Pattern: Architecture by implication
===================

-        | Value
-------- | ---
Anti-Pattern Name | Architecture by implication
Andere Namen      | Wherefore art thou architecture?
Kategorie | Software Architecture
Anekdote    | "We've done systems like this before!", "There is no risk; we know what we'are doing!"

Kurzzusammenfassung
-------------------
Dieses AntiPattern kennzeichnet sich dadurch, dass wichtige Architketur Spezifikationen / Planungsdokumente schlichtweg fehlen. Es wird also ohne Planung entwickelt! Kann zum Fehlschlagen des ganzen Projekts führen.

Erscheinungsform
----------------
- keine Planungsdokument oder Spezifikationen vorhanden
- Entwicklung läuft also ohne Planung
- Verantworliche für Projekt haben Erfahrung mit ähnlichen Projekten und glauben deshalb das ganze ohne Planung händeln zu können

Symptome
--------
- fehlende Planungsdokumente in verschiedenen Bereichen
- Lösung einiger Probleme schlichtweg auf Entwicklungsprozess verschoben 

Ursachen
--------
- fehlendes Risiko-Management
- Selbstüberschätzung der teilnehmenden Personen
- Verlassen auf frühere Erfahrungen

Konsequenzen
------------
- Versteckte Risiken bezüglich Komplexität, Technologien usw. -> tauchen erst mit Projektfortschritt auf
- erstellte Lösung ist unnutzbar, bedingt nicht beachtete Voraussetzungen
- Ignoranz gegenüber neuen Technologien
- Fehlen von Notfallplänen
- schlechtes Design des Codings (Torben)

Lösung / Refactoring
--------------------
- naja liegt auf der Hand: _> **PLANEN**