# interval-merger-demo für Mercedes Benz Tech Innovation GmbH Interview Philipp Engels

# Überblick
Das IntervalMerger-Projekt wurde im Rahmen des Tech Interviews für die Mercedes Benz Tech Innovation entworfen und bietet eine beispielhafte Implementierung zum Mergen überlappender Intervalle. Es nimmt eine Liste von Intervallen entgegen, wobei jedes Intervall durch ein Paar von Ganzzahlen (Start- und Endpunkt) repräsentiert wird, und produziert eine neue Liste, in der alle sich überlappenden Intervalle zu größeren Intervallen verschmolzen sind. Diese Operation reduziert die Anzahl der Intervalle und behält dabei die vollständige Abdeckung aller ursprünglichen Intervalle bei.

# Konzeptionelle Grundlagen
Ein Intervall wird als ein kontinuierlicher Teil einer Zahlengeraden definiert, gekennzeichnet durch einen Anfangs- und einen Endpunkt. Zwei Intervalle gelten als überlappend, wenn sie mindestens einen Punkt gemeinsam haben.

# Implementierungsdetails
Die Kernfunktionalität wird durch die Klasse IntervalMerger realisiert, welche die Methode merge bereitstellt. Die Methode merge nimmt eine Liste von Interval-Objekten als Eingabe und gibt eine Liste von Interval-Objekten zurück, wobei sich überlappende Intervalle zu einem einzigen Intervall vereinigt wurden.

# Die Interval Klasse
Die Interval-Klasse ist eine einfache Datenstruktur, die ein Intervall mit einem Start- und einem Endpunkt repräsentiert. Sie bietet grundlegende Funktionalitäten, um diese Punkte zu setzen und abzufragen.

# Die merge Methode
Die merge Methode implementiert den Algorithmus zur Vereinigung überlappender Intervalle. Sie durchläuft die Liste der Intervalle, sortiert sie nach ihren Anfangspunkten, und vereinigt alle aufeinanderfolgenden Intervalle, die sich überlappen, zu einem einzigen Intervall. Das Ergebnis ist eine Liste von Intervallen, in der kein Intervall mit einem anderen überlappt.

# Benutzung von Dritten
Um die IntervalMerger-Bibliothek zu nutzen, muss zuerst eine Instanz der IntervalMerger-Klasse erstellt werden. Anschließend kann die merge-Methode aufgerufen werden, indem eine Liste von Interval-Objekten übergeben wird. Das Ergebnis ist eine neue Liste von Interval-Objekten, die die gemergten Intervalle enthält.

# Erweiterung und Anpassung
Die IntervalMerger-Bibliothek wurde mit Blick auf Einfachheit und Erweiterbarkeit gecoded. Weiterführende Teams von Entwicklerinnen und Entwickler könnten die Implementierung leicht anpassen, um zusätzliche Funktionalitäten einzuführen oder den Anwendungsfall für spezifischere Anwendungsfälle zu optimieren.

# Ausführung
# Voraussetzungen
Um dieses Projekt auszuführen wird benötigt:

- Java JDK 8 oder höher
- Ein bevorzugtes Entwicklungstool wie IntelliJ IDEA, Eclipse oder einfach einen Texteditor und die Kommandozeile.

# Installation
Klonen Sie das Repository
- git clone https://github.com/phil-angeles/interval-merger-demo.git

# Navigieren Sie zum Projektverzeichnis
cd interval-merger
Kompilieren Sie den Quellcode (optional, abhängig von Ihrer Entwicklungsumgebung)
z.B. :
- javac -d bin src/*.java

# Ausführung
Um das Projekt auszuführen und zu sehen, wie der Intervall-Merge funktioniert, können Sie die IntervalMergerRunner-Klasse ausführen, welche eine main-Methode enthält.

In Ihrer IDE, navigieren Sie zur IntervalMergerRunner.java-Datei, klicken Sie mit der rechten Maustaste darauf und wählen Sie Run.
Alternativ können Sie, wenn Sie die Kommandozeile verwenden, folgenden Befehl im bin-Verzeichnis ausführen:

java IntervalMergerRunner

# - English Version -
# Overview
The IntervalMerger project was designed as part of the Tech Interview for the Mercedes Benz Tech Innovation and provides an exemplary implementation for merging overlapping intervals. It takes a list of intervals, where each interval is represented by a pair of integers (start and end points), and produces a new list in which all overlapping intervals are merged into larger intervals. This operation reduces the number of intervals while maintaining full coverage of all original intervals.

# Conceptual basics
An interval is defined as a continuous part of a number line, characterized by a start point and an end point. Two intervals are considered overlapping if they have at least one point in common.

# Implementation details
The core functionality is realized by the IntervalMerger class, which provides the merge method. The merge method takes a list of interval objects as input and returns a list of interval objects where overlapping intervals have been merged into a single interval.

# The Interval class
The Interval class is a simple data structure that represents an interval with a start and an end point. It offers basic functionalities to set and query these points.

# The merge method
The merge method implements the algorithm for merging overlapping intervals. It runs through the list of intervals, sorts them according to their starting points, and merges all consecutive intervals that overlap into a single interval. The result is a list of intervals in which no interval overlaps with another.

# Use of third parties
To use the IntervalMerger library, an instance of the IntervalMerger class must first be created. The merge method can then be called by passing a list of Interval objects. The result is a new list of interval objects containing the merged intervals.

# Extension and customization
The IntervalMerger library has been coded with simplicity and extensibility in mind. Further teams of developers could easily adapt the implementation to introduce additional functionalities or optimize the use case for more specific use cases.

# Execution
# Prerequisites
To run this project you need:

- Java JDK 8 or higher
- A preferred development tool such as IntelliJ IDEA, Eclipse or simply a text editor and the command line.

# Installation
Clone the repository
git clone https://github.com/phil-angeles/interval-merger-demo.git

# Navigate to the project directory
cd interval-merger
Compile the source code (optional, depending on your development environment)
e.g. :
- javac -d bin src/*.java

# Execution
To run the project and see how the interval merge works, you can run the IntervalMergerRunner class, which contains a main method.

In your IDE, navigate to the IntervalMergerRunner.java file, right-click on it and select Run.
Alternatively, if you are using the command line, you can execute the following command in the bin directory:

java IntervalMergerRunner

