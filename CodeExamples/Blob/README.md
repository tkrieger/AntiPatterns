# AntiPattern: The Blob [Example]
Hier ein Beispiel für einen Blob (einer Gott-Klasse) in produktiven Code. In diesem Fall handelt es sich um C++ Code aus der Java Virtual Machine (Hotspot) des OpenJDK Projekts. Die Klasse ist Element des G1 Garbage Collectors und stellt eigentlich den Heap da. Allein die Definition (innerhalb der Datei G1CollectedHeap.hpp) umfasst 1469 beginnend bei Zeile 179 und ended bei 1648. Die Implementation (G1CollectedHeap.cpp) ist noch um weiten länger...