--liquibase formatted sql
--changeset segu121:6



-- SET IDENTITY INSERT ingredients off;
-- SET IDENTITY INSERT category off;
-- SET IDENTITY INSERT ingredient_category off;
INSERT INTO ingredients (id, name, natural_rating, description, INCI_name,  rating) VALUES (1, 'woda', 1, 'Woda w kosmetyku pełni funkcję rozpuszczalnika, wpływa na konsystencję produktu i jest nośnikiem aktywnych substancji w niej rozpuszczalnych. Jeżeli do produkcji kosmetyków stosujemy wodę termalną lub hydrolaty kwiatowe to woda pełni wtedy także funkcję składnika aktywnego.', 'AQUA', 1);
INSERT INTO ingredients (id, name, natural_rating, description, INCI_name,  rating) VALUES (2, 'Glikol Propylenowy', 2, 'Hydrofilowa substancja nawilżająca skórę. Ma zdolność przenikania przez warstwę rogową naskórka, dzięki czemu pełni rolę promotora przenikania, ułatwia w ten sposób transport składników aktywnych kosmetyku w głąb naskórka. Tworzy na powierzchni skóry hydrofilowy film ograniczający TEWL (transepidermalną utratę wody). Jest substancją bezpieczną nawet w stężeniu 50% w gotowym preparacie do włosów. Nie poleca się stosowania kremów zawierających w swym składzie glikol propylenowy osobom ze skórą wrażliwą, skłonną do alergii, jak również dzieciom. Mimo zdolności wiązania wody, istnieje teoria, że może przyczyniać się, również do jej ucieczki przez naskórek, ze względu na zmianę struktury cementu międzykomórkowego warstwy rogowej. Z tego powodu glikol propylenowy znalazł się na liście substancji zakazanych w kosmetykach naturalnych.', 'PROPYLENE GLYCOL', 2);



INSERT INTO category (id, name) VALUES (3, 'Rozpuszczalnik');
INSERT INTO category (id, name) VALUES (4, 'Humektant');


