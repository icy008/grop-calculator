-- Insert data for Age table
INSERT INTO age (label, value, units ,timestamp) VALUES 
('80-84', 0.29129, '(years)',NOW()),
('85-89', 0.29129, '(years)',NOW()),
('≥90', 0.43853, '(years)',NOW());

-- Insert data for Sex table
INSERT INTO gender (label, value, units ,timestamp) VALUES 
('Male', 0.51578, '',NOW()),
('Female', 0.48422, '',NOW());

-- Insert data for Barthel Index table
INSERT INTO barthel_index (label, value, units ,timestamp) VALUES 
('≥90', 0, '',NOW()),
('61–90', 0.34902, '',NOW()),
(' ≤60', 0.78954, '',NOW());

-- Insert data for History of HF table
INSERT INTO history_hf (label, value, units ,timestamp ) VALUES 
('No', 0, '',NOW()),
('Yes', 0.35664, '',NOW());

-- Insert data for SBP table
INSERT INTO sbp_admission (label, value, units ,timestamp) VALUES 
('≥100', 0, '(mmHg)',NOW()),
('<100', 0.31585, '(mmHg)',NOW());

-- Insert data for Hemoglobin table
INSERT INTO hemoglobin (label, value, units ,timestamp) VALUES 
('≥12', 0, '(g/dL)',NOW()),
('10-11.9', 0.23813, '(g/dL)',NOW()),
('<10', 0.40091, '(g/dL)',NOW());

-- Insert data for Albumin table
INSERT INTO albumin (label, value, units ,timestamp) VALUES 
('≥3', 0, '(g/dL)',NOW()),
('<3', 0.37812, '(g/dL)',NOW());

-- Insert data for BUN table
INSERT INTO bun (label, value, units ,timestamp) VALUES 
('<25', 0, '(mg/dL)',NOW()),
('≥25', 0.21341, '(mg/dL)',NOW());

-- Insert data for BNP table
INSERT INTO bnp (label, value, units ,timestamp) VALUES 
('<300', 0, '(pg/dL)',NOW()),
('≥300', 0.29743, '(pg/dL)',NOW());

-- Insert data for Sodium table
INSERT INTO sodium (label, value, units ,timestamp) VALUES 
('≥130', 0, '(mEq/L)',NOW()),
('<130', 0.60705, '(mEq/L)',NOW());

-- Insert data for ACE/ARB Use table
INSERT INTO ace_arm_use (label, value, units ,timestamp) VALUES 
('No', 0.20517, '',NOW()),
('Yes', 0.79483, '',NOW());
