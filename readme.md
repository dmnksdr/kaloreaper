## 1.Wstęp 
W tym dokumencie zawarto podstawowe informacje dotyczące Doradcy Żywieniowego, jego założenia, wymagania oraz sposób użycia.


## 2. Opis problemu
**Problem:** Prowadzenie dziennika spożytych posiłków oraz monitorowanie ich kaloryczności i zgodności ze stosowaną dietą jest czynnością żmudną i bardzo powtarzalną. Ponadto dobór posiłków pod względem dostarczanych makroskładników: białek, węglowodanów i tłuszczy wymaga sporej wiedzy i śledzenia odpowiednich tabel. 
Czynności te nastręczają wiele trudności i wymagają włożenia sporej ilości czasu (zapisywanie, podliczanie kalorii, sprawdzanie kaloryczności konkretnego dania). 

**Rozwiązanie:** Stworzenie systemu ułatwiającego i pewnym stopniu automatyzującego wyżej wspomniane czynności. System pozwalałby na automatyczną kalkulację kaloryczności oraz zawartości makroskładników na podstawie wprowadzonych posiłków oraz ich porównanie z założeniami.


## 3. Warunki graniczne.
Warunki graniczne zostaną przedstawione z wykorzystaniem techniki MoSCoW. 
Must opisuje wymaganie, które musi być spełnione w końcowym, finalnym rozwiązaniu. Should reprezentuje pozycję o wysokim priorytecie, która powinna być zawarta w rozwiązaniu, jeżeli jest to możliwe. Could opisuje wymaganie, które jest postrzegane jako pożądane, ale niekonieczne. Zostanie ono zawarte, jeżeli pozwolą na to czas i zasoby. Won’t reprezentuje wymaganie, które – za zgodą interesariuszy – nie będzie implementowane w danym wydaniu, ale może być rozpatrzone w przyszłości.

`Must have`
- [ ] Użytkownik będzie miał możliwość stworzenia swojego osobistego konta, na które będzie mógł zalogować się poprzez przeglądarkę z dowolnego miejsca.
- [ ] System będzie dysponował bazą produktów spożywczych wraz z danymi o ich kaloryczności oraz zawartości makroskładników
- [ ] System będzie umożliwiał prowadzenie dziennika posiłków, czyli zestawienia produktów wraz z ich wagami na podstawie których obliczone zostaną spożyte: kalorie, białka, tłuszcze oraz węglowodany.
- [ ] Powyższe dane (zapotrzebowanie oraz aktualne spożycie) będą wyświetlane w przejrzystej formie na głównym panelu aplikacji tak, aby użytkownik po szybkiej ich ocenie mógł stwierdzić czy osiągnął swój dzienny cel.
- [ ] System będzie umożliwiał generowanie okresowych podsumowań zawierających wykresy spożycia kalorii i poszczególnych makroelementów. Na wykres można także nanieść informację czy wynik z danego dnia mieścił się w założonym limicie.

`Should have`
- [ ] Dodatkowym ułatwieniem będzie możliwość tworzenia predefiniowanych posiłków, które będą przechowywane w bazie danych i będą dostępne tylko dla użytkownika który je stworzył. Przy uzupełnianiu dziennika posiłków, zamiast dodawania poszczególnych produktów, będzie możliwość dodania gotowego posiłku.
- [ ] Dodawanie przez użytkownika własnych produktów wraz z zawartością makroelementów oraz kalorycznością. Dane te powinny być przechowywane w osobnej tabeli właściwej dla konkretnego użytkownika.

`Could have`
- [ ] Użytkownik będzie mógł przystąpić do ankiety na podstawie której dobrane zostaną dla niego parametry diety takie jak dzienne zapotrzebowanie kaloryczne oraz zapotrzebowanie na makroskładniki.

`Won’t have`
- [ ] Użytkownik będzie mógł zalogować się do systemu za pomocą dedykowanej aplikacji mobilnej na system Android oraz iOS.
- [ ] Użytkownik będzie miał możliwość wykupienia konta premium, które będzie pozwalać na uzyskanie personalnej porady dietetycznej i ułożenia diety. Wymagałoby to korzystania z usług wykwalifikowanego dietetyka.



## 4. Opis użytkownika i zewnętrznych podsystemów
W podstawowej wersji system będzie posiadał dwóch użytkowników:
1. Administrator 
- Zarządzanie kontami użytkowników
- Zarządzanie i utrzymywanie(dodawanie, usuwanie, modyfikacja) bazy produktów
- Utrzymywanie aplikacji
2. Użytkownik 
- Tworzenie prywatnego konta użytkownika i uzupełnienie go swoimi danymi
- Wybranie celu diety - schudnięcie, przybranie masy mięśniowej, zdrowsze odżywianie
- Prowadzenie dziennika zjedzonych posiłków
- Komponowanie predefiniowanych posiłków, które później będą mogły być dodane do dziennika
- Generowanie podsumowań
- Podsystemy
- Baza danych
- Przechowywanie danych użytkowników
- Przechowywanie danych o produktach
- Przechowywanie danych o posiłkach
- Przechowywanie dzienników posiłków
