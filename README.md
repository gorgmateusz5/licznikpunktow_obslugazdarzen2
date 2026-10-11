
W aplikacji „Licznik punktów dwóch drużyn” zmieniono sposób obsługi kliknięć. W poprzedniej wersji wykorzystywano wyrażenia lambda. W nowej wersji klasa MainActivity implementuje interfejs View.OnClickListener, a obsługa wszystkich przycisków odbywa się w metodzie onClick(View v).

Przyciski korzystają z setOnClickListener(this), a rozpoznawanie klikniętego przycisku odbywa się za pomocą getId(). Zachowano dotychczasową funkcjonalność aplikacji, w tym dodawanie i odejmowanie punktów, blokowanie ujemnego wyniku, wyświetlanie komunikatów Toast oraz resetowanie wyniku.

Po zmianie przetestowano działanie aplikacji i zapisano modyfikację w repozytorium Git.
