INSERT INTO roles(name) VALUES
                            ('ROLE_USER'),
                            ('ROLE_ADMIN');
INSERT INTO graphic_cards(component_name, price, video_memory) VALUES
    ('Geforce GTX 1660 Super', 300, 4),
    ('Geforce RTX 2060', 500, 6);

INSERT INTO hard_drives(component_name, price, storage_memory) VALUES
    ('WD Blue', 150, 256),
    ('WD Black', 250, 512);

INSERT INTO operative_memories(component_name, details, price, memory_amount) VALUES
    ('Corsair 8gb', null, 50, 8),
    ('Corsair 16gb', null, 125, 16);

INSERT INTO processors(component_name, details, price, cores) VALUES
    ('Intel Core i5', null, 300, 4),
    ('Intel Core i7', null, 500, 6);

INSERT INTO computers(graphic_card_id, operative_memory_id, processor_id, hard_drive_id) VALUES
    (1, 1, 1, 1),
    (2, 2, 2, 2);

INSERT INTO categories(category_name, max_cpu_cores, max_operative_memory, max_video_memory, min_cpu_cores, min_operative_memory, min_storage_memory, min_video_memory) VALUES
    ('gaming', null, null, null, 6, 16, 256, 6),
    ('educational', 4, 16, 6, 2, 4, 128, 2);
