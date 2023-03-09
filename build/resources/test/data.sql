INSERT INTO `accounts`
(`account_type`, `password`, `username`)
VALUES
    ('Admin','Password123','ThisIsAnExampleUser'),
    ('Admin','Password123','SuperUser123');

INSERT INTO `applications`
(`application_status`, `application_status_comments`, `confirmation_comments`, `contextual`, `correspondence_lang`,
 `country`, `course_code`, `date_of_birth`, `date_received`, `dbs_cert_number`, `email`, `enrolment_criteria_comments`,
 `entry_year`, `essential_to_dos`, `fa_status`, `fee_status`, `fee_status_comments`, `first_created`, `ftp_checked`,
 `gender`, `grades_achieved`, `highest_qualification`, `interview_comments`, `interview_date`, `interview_score`,
 `invite_to_interview`, `issue_date`, `keep_email_sent`, `latest_decision`, `name`, `nationality`, `non_standard_email`,
 `offer_conditions`, `offer_email_sent`, `personal_id`, `personal_statement_score`, `status_code`, `student_number`,
 `surname`, `ucas_code`, `update_service`, `welsh_speaker`)
VALUES
    ('0xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000077040000000078',
     '', '', 'Y', 'N', 'Wales', 'UFBWMIDA', '01-Jan-1991', '23.11.17', '', 'N/A', '', '2018/9', '', '',
     '', '', '23-Nov-2017', 'Y', 'F', '', 'pending A Levels', '', '14.02.18', '46.0', 'Y', '', 'Y', '', 'MARY', 'United Kingdom', '', '', '',
     '1345678902', '59.0', 'A', '09456712', 'POPPINS', 'B720', '', 'Y'),
    ('0xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000077040000000078',
     '', '', 'Y', 'N', 'Wales', 'UFBWMIDA', '01-Jan-1991', '23.11.17', '', 'N/A', '', '2018/9', '', '',
     '', '', '23-Nov-2017', 'Y', 'F', '', 'pending A Levels', '', '14.02.18', '46.0', 'Y', '', 'Y', '', 'MARY', 'United Kingdom', '', '', '',
     '1345678902', '59.0', 'A', '09456712', 'POPPINS', 'B720', '', 'Y');

INSERT INTO `statistics`
(`offers`, `places`, `study_year`)
VALUES
    ('34','120','2022/23'),
    ('45','222','2023/24');

