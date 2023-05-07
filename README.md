ct1023puzzle
============

Program for finding words in a matrix and solving the quiz in [c't 2023/10](https://www.heise.de/select/ct/2023/10/2306913042732357274) (German computer magazine).

## Build / Run
JDK ≥ 8 required.
```
mvn clean compile test

java -cp target/classes de.jkaufma.ct1023puzzle.CT1023PuzzleMain
```

As it might only be interesting for those who can read the article and have participated in the quiz the following explanations are only in German.


----

Programm zum Finden von Wörtern im Buchstaben-Puzzle der [c't 2023/10](https://www.heise.de/select/ct/2023/10/2306913042732357274).

## Beschreibung
Das Programm iteriert über sämtliche 256 Elemente der [Buchstabenmatrix](https://ct.de/yqch) ([PDF](matrix_gross_10.pdf)) und startet dann jeweils davon ausgehend einen rekursiven *Backtracking* Algorithmus, um nach den vorgegebenen Regeln gültige Wörter zu bilden.  Dabei ist die Default-Voraussetzung, dass jedes Buchstabenelement nur einmal verwendet werden darf (`allowLetterMultipleTimes = false`).

Bei jedem Rekursionsschritt wird das aktuell gebildete Wort mit einer (oder mehrerer) zuvor geladenen Wortliste abgeglichen.  Jedes darin enthaltene Wort wird gespeichert, sofern es eine vorgegeben Mindestlänge besitzt (`wordMinLength`).  Sobald es nicht mehr möglich ist, dass aus der aktuell gebildeten Buchstabenreihenfolge ein gültiges Wort entsteht, welches also in der Wortliste enthalten ist, wird die Rekursion an dieser Stelle beendet.

Nachdem der Algorithmus durchlaufen wurde, wird in einem abschließenden Schritt versucht, Komposita zu bilden und so die Wortliste nochmals zu vergrößern.  Dazu wird über die Liste der bereits gefundenen Wörter iteriert und geprüft, ob sich an das Ende des jeweiligen Wortes ein anderes Wort der Liste anschließt.  Auch dabei wird sichergestellt, dass in einem solchen Kompositum keine Buchstabenfelder mehrfach verwendet werden.
Insbesondere dieser Schritt benötigt allerdings eine manuelle Prüfung der entstandenen Wörter hinsichtlich ihrer Sinnhaftigkeit.


### Verwendete oder verfügbare Wortlisten:
Wortliste|Sprache|Quelle
---|---|---
[`words_alpha.txt`](https://github.com/dwyl/english-words/raw/master/words_alpha.txt)|en|https://github.com/dwyl/english-words
[`twl06.txt`](https://github.com/speedreeder/ScrabbleWordChecker/raw/master/twl06.txt)|en|https://github.com/speedreeder/ScrabbleWordChecker
[`sowpods.txt`](https://github.com/speedreeder/ScrabbleWordChecker/raw/master/sowpods.txt)|eu|https://github.com/speedreeder/ScrabbleWordChecker
[`en.txt`](https://github.com/lorenbrichter/Words/raw/master/Words/en.txt)|en|https://github.com/lorenbrichter/Words
[`de.txt`](https://github.com/lorenbrichter/Words/raw/master/Words/de.txt)|de|https://github.com/lorenbrichter/Words
[`hippler-german-wordlist.txt`](https://github.com/hippler/german-wordlist/raw/master/words)|de|https://github.com/hippler/german-wordlist
[`additional_words.txt`](src/main/resources/wordlists/additional_words.txt)|de|eigene Ergänzungen

