COPY ingredients
    FROM 'ABSOLUTE_PATH_TO_skladniki.csv'
    DELIMITER ';' CSV HEADER encoding 'windows-1250';

-- encoding musi by� ustawiony zgodnie z waszym systemowym UTF-8,
-- u mnie IntelliJ wykry� automatycznie potrzeb� zmiany po otworzeniu pliku "skladniki.csv"