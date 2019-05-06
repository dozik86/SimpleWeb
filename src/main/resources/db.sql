CREATE TABLE public.employee
(
    employee_id   SERIAL      NOT NULL,
    first_name    VARCHAR(25) NOT NULL,
    last_name     VARCHAR(25) NOT NULL,
    department_id INTEGER     NOT NULL,
    job_title     VARCHAR(35) NOT NULL,
    gender        VARCHAR(10) NOT NULL,
    date_of_bith  date        NOT NULL
);

CREATE UNIQUE INDEX employee_employee_id_uindex ON public.employee (employee_id);

INSERT INTO employee (first_name,
                      last_name,
                      department_id,
                      job_title,
                      gender,
                      date_of_bith)
values ('Eugene', 'Sobakevich', '1', 'developer', 'male', '1995-05-06');

INSERT INTO employee(first_name,
                     last_name,
                     department_id,
                     job_title,
                     gender,
                     date_of_bith)
values ('Alex', 'Simonov', '2', 'QA', 'male', '1986-06-26');

INSERT INTO employee(first_name,
                     last_name,
                     department_id,
                     job_title,
                     gender,
                     date_of_bith)
values ('Elizabeth', 'Gingerbread', '1', 'developer', 'female', '1995-12-05');