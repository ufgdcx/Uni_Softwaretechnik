\ProvidesClass{Handbuch}
\LoadClass[11pt, a4paper]{article}
\usepackage[utf8]{inputenc}
\usepackage[ngerman]{babel} 
\usepackage[pdftex]{graphicx}	
\usepackage{color}
\usepackage{url}
\usepackage{setspace}
\usepackage{tikz}
\usepackage[top=2.5cm,bottom=2.0cm,left=2.5cm,right=2.5cm]{geometry}
\usepackage[ % Paket zur Erstellung von Links in der PDF-Datei.
   colorlinks, % Links ohne Umrandungen in zu wählender Farbe.
   linkcolor=black, % Farbe interner Verweise.
   filecolor=black, % Farbe externer Verweise.
   citecolor=black % Farbe von Zitaten.
]{hyperref}
\usepackage{array}

\usepackage[font=sc,]{caption} % Paket zum Formatieren der Abbildungs- und Tabellenunterschriften, Dokumentation siehe: ftp://ctan.sharelatex.com/pub/tex-archive/macros/latex/contrib/caption/caption-deu.pdf

\usepackage{titlesec}
\titleformat{\section} % Kapitelüberschrift in Kapitälchen.
  {\large\bfseries}{\thesection}{0.5cm}{}
\titleformat{\subsection} % Überschrift der subsection in Kapitälchen.
  {\large\bfseries}{\thesubsection}{0.5cm}{}
\titleformat{\subsubsection} % Überschrift der subsubsection in Kapitälchen.
  {\large\bfseries}{\thesubsubsection}{0.5cm}{}
 
\usepackage[hang]{footmisc} % Paket zur Bearbeitung des Fußnotenformats.

\definecolor{uni}{cmyk}{0.80, 1.00, 0.00, 0.00} % Philosophische Fakultät

\onehalfspacing % Zeilenabstand ist anderthalbzeilig.

\usepackage{fancyhdr} % Paket zur Erstellung von Kopfzeilen.
\fancypagestyle{plain}{%
\fancyhf{}}
\renewcommand{\headrulewidth}{0.4pt} % Obere Linie.
\renewcommand{\footrulewidth}{0.4pt} % Untere Linie.
	\pagestyle{fancy}
\renewcommand{\sectionmark}[1]{\markboth{\thesection \ #1}{}} % Umdefininieren des Befehls zum Anzeigen des Kapitels. Darstellung in Kapitälchen.
%	\fancyhead{}			
%	\fancyfoot{}
	\lhead{\leftmark} % Text oben links.
	\rhead{} % Text oben rechts.

% Befehl zum Setzen von Logo und Rahmen. Zwei Variablen für den Text in der unteren Box.
\newcommand{\titelseite}[2]{
\begin{tikzpicture}[overlay]
\draw [rounded corners, line width=1.5pt, color=uni] (-1.2,-4) rectangle (16, -28);
\node [right] at (-1.2,0) {\includegraphics[width=12cm]{Handbuch.png}};
\draw [fill=uni, thick, line width=1.5pt, color=uni] (-1.2,-28) rectangle (16, -23.5);
\node [right, white] at (0,-24.25) {\large{\textsc{#1}}};
\node [right, white] at (0,-25.25) {\large{\textsc{#2}}};
\end{tikzpicture}
}

% Befehl zum Einfügen von Titel und Untertitel.
\newcommand{\titel}[2]{
\begin{center}
\textcolor{uni}{\huge{\textsc{#1}}}\\[1cm]
\textcolor{uni}{\LARGE{\textsc{#2}}}\\[5cm]
\end{center}
}

% Befehl zum Einfügen von Titel und Untertitel. (B.A.-Arbeit)
\newcommand{\BAtitel}[2]{
\begin{center}
%\bfseries{\textsc{\LARGE{Bachelorarbeit zum Thema}}}\\[1cm]
\textcolor{uni}{\huge{\textsc{#1}}}\\[1cm]
\textcolor{uni}{{\textsc{#2}}}\\[5cm]
\end{center}
}

% Befehl zum Einfügen von Titel und Untertitel. (M.A.-Arbeit)
\newcommand{\MAtitel}[2]{
\begin{center}
\textsc{Masterarbeit zum Thema}\\[1cm]
\textcolor{uni}{\huge{\textsc{#1}}}\\[1cm]
\textcolor{uni}{\LARGE{\textsc{#2}}}\\[5cm]
\end{center}
}

\usepackage{mathtools}
\usepackage{amssymb}