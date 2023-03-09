drop table if exists `accounts`;
create table if not exists `accounts`(
       `id` int auto_increment primary key,
   `account_type` varchar(255) null,
    `password` varchar(255) null,
    `username` varchar(255) null,
    `is_super_user` bit null
    );

drop table if exists `applications`;
create table if not exists `applications`(
   `id` int auto_increment primary key,
    `application_status`          varbinary(255) null,
    `application_status_comments` varchar(255) null,
    `confirmation_comments`       varchar(255)  null,
    `contextual`                  varchar(255)   null,
    `correspondence_lang`         varchar(255)   null,
    `country`                     varchar(255)   null,
    `course_code`                 varchar(255)   null,
    `date_of_birth`               varchar(255)   null,
    `date_received`               varchar(255)   null,
    `dbs_cert_number`             varchar(255)   null,
    `email`                       varchar(255)   null,
    `enrolment_criteria_comments` varchar(255)   null,
    `entry_year`                  varchar(255)   null,
    `essential_to_dos`            varchar(255)   null,
    `fa_status`                   varchar(255)   null,
    `fee_status`                  varchar(255)   null,
    `fee_status_comments`         varchar(255)   null,
    `first_created`               varchar(255)   null,
    `ftp_checked`                 varchar(255)   null,
    `gender`                      varchar(255)   null,
    `grades_achieved`             varchar(255)   null,
    `highest_qualification`       varchar(255)   null,
    `interview_comments`          varchar(255)   null,
    `interview_date`              varchar(255)   null,
    `interview_score`             varchar(255)   null,
    `invite_to_interview`         varchar(255)   null,
    `issue_date`                  varchar(255)   null,
    `keep_email_sent`             varchar(255)   null,
    `latest_decision`             varchar(255)   null,
    `name`                        varchar(255)   null,
    `nationality`                 varchar(255)   null,
    `non_standard_email`          varchar(255)   null,
    `offer_conditions`            varchar(255)   null,
    `offer_email_sent`            varchar(255)   null,
    `personal_id`                 varchar(255)   null,
    `personal_statement_score`    varchar(255)   null,
    `status_code`                 varchar(255)   null,
    `student_number`              varchar(255)   null,
    `surname`                     varchar(255)   null,
    `ucas_code`                   varchar(255)   null,
    `update_service`              varchar(255)   null,
    `welsh_speaker`               varchar(255)   null
    );

drop table if exists `statistics`;
create table if not exists `statistics`(
     `id` int auto_increment primary key,
     `offers`     int          not null,
     `places`     int          not null,
     `study_year` varchar(255) null
);

