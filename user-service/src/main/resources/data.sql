INSERT INTO public.users (birth_date, latitude, longitude, created_at, creator_id, updated_at, updated_id, gender, user_status, name, surname, email) VALUES ('1990-01-15', 40.74, -74.1, '2022-01-01 00:00:00.000000', 1, '2022-01-01 00:00:00.000000', 1, 'MALE', 'ACTIVE', 'John', 'Doe', 'john.doe@example.com');
INSERT INTO public.users (birth_date, latitude, longitude, created_at, creator_id, updated_at, updated_id, gender, user_status, name, surname, email) VALUES ('1985-05-20', 40.7, -73.93, '2022-01-02 00:00:00.000000', 2, '2022-01-02 00:00:00.000000', 2, 'FEMALE', 'ACTIVE', 'Jane', 'Smith', 'jane.smith@example.com');
INSERT INTO public.users (birth_date, latitude, longitude, created_at, creator_id, updated_at, updated_id, gender, user_status, name, surname, email) VALUES ('1998-08-10', 40.69, -74.07, '2022-01-03 00:00:00.000000', 1, '2022-01-03 00:00:00.000000', 1, 'MALE', 'ACTIVE', 'Bob', 'Jones', 'bob.jones@example.com');
INSERT INTO public.users (birth_date, latitude, longitude, created_at, creator_id, updated_at, updated_id, gender, user_status, name, surname, email) VALUES ('1980-03-25', 40.69, -73.99, '2022-01-04 00:00:00.000000', 3, '2022-01-04 00:00:00.000000', 3, 'FEMALE', 'INACTIVE', 'Alice', 'Miller', 'alice.miller@example.com');
INSERT INTO public.users (birth_date, latitude, longitude, created_at, creator_id, updated_at, updated_id, gender, user_status, name, surname, email) VALUES ('1995-12-03', 40.72, -74.05, '2022-01-05 00:00:00.000000', 2, '2022-01-05 00:00:00.000000', 2, 'MALE', 'ACTIVE', 'David', 'Wilson', 'david.wilson@example.com');
INSERT INTO public.users (birth_date, latitude, longitude, created_at, creator_id, updated_at, updated_id, gender, user_status, name, surname, email) VALUES ('1987-09-18', 40.72, -73.95, '2022-01-06 00:00:00.000000', 3, '2022-01-06 00:00:00.000000', 3, 'FEMALE', 'INACTIVE', 'Emily', 'Brown', 'emily.brown@example.com');
INSERT INTO public.users (birth_date, latitude, longitude, created_at, creator_id, updated_at, updated_id, gender, user_status, name, surname, email) VALUES ('1993-07-12', 40.68, -73.92, '2022-01-07 00:00:00.000000', 1, '2022-01-07 00:00:00.000000', 1, 'MALE', 'ACTIVE', 'Charlie', 'Anderson', 'charlie.anderson@example.com');
INSERT INTO public.users (birth_date, latitude, longitude, created_at, creator_id, updated_at, updated_id, gender, user_status, name, surname, email) VALUES ('1983-11-30', 40.75, -73.97, '2022-01-08 00:00:00.000000', 2, '2022-01-08 00:00:00.000000', 2, 'FEMALE', 'INACTIVE', 'Olivia', 'White', 'olivia.white@example.com');
INSERT INTO public.users (birth_date, latitude, longitude, created_at, creator_id, updated_at, updated_id, gender, user_status, name, surname, email) VALUES ('1991-04-22', 40.72, -73.96, '2022-01-09 00:00:00.000000', 3, '2022-01-09 00:00:00.000000', 3, 'MALE', 'ACTIVE', 'Samuel', 'Martin', 'samuel.martin@example.com');
INSERT INTO public.users (birth_date, latitude, longitude, created_at, creator_id, updated_at, updated_id, gender, user_status, name, surname, email) VALUES ('1989-06-05', 40.73, -74.05, '2022-01-10 00:00:00.000000', 1, '2022-01-10 00:00:00.000000', 1, 'FEMALE', 'ACTIVE', 'Ava', 'Thompson', 'ava.thompson@example.com');

INSERT INTO public.user_reviews (created_at, creator_id, updated_at, updated_id, comment, restaurant_id, user_rate, user_id) VALUES
('2024-03-11 17:57:10.354737', 3, '2024-03-11 17:57:10.354737', 1, 'Great food!', '1', 1.00, 1),
('2024-03-11 17:57:10.354737', 2, '2024-03-11 17:57:10.354737', 2, 'Good service', '2', 2.00, 2),
('2024-03-11 17:57:10.354737', 4, '2024-03-11 17:57:10.354737', 3, 'Excellent atmosphere', '3', 3.00, 3),
('2024-03-11 17:57:10.354737', 1, '2024-03-11 17:57:10.354737', 4, 'Could be better', '4', 4.00, 4),
('2024-03-11 17:57:10.354737', 3, '2024-03-11 17:57:10.354737', 5, 'Nice place', '5', 5.00, 5),
('2024-03-11 17:57:10.354737', 2, '2024-03-11 17:57:10.354737', 6, 'Average food', '6', 1.00, 6),
('2024-03-11 17:57:10.354737', 4, '2024-03-11 17:57:10.354737', 7, 'Loved it!', '7', 2.00, 7),
('2024-03-11 17:57:10.354737', 1, '2024-03-11 17:57:10.354737', 8, 'Not my favorite', '8', 3.00, 8),
('2024-03-11 17:57:10.354737', 3, '2024-03-11 17:57:10.354737', 9, 'Good overall', '9', 4.00, 9),
('2024-03-11 17:57:10.354737', 2, '2024-03-11 17:57:10.354737', 10, 'Okay experience', '10', 5.00, 10);

