/* 1. Să se selecteze deptno, enume, job și sal pentru angajatii care au seful cu id-ul 7902. */
SELECT deptno,
       ename,
       job,
       sal
from emp
where mgr = 7902;

/* 2. Să se selecteze numele, funcția și salariu pentru angajații care au aceași funcție. */
SELECT a.ename,
       a.job,
       a.sal
from emp as a
where job = 'SALESMAN';

/* 3. Să se selecteze numele, funcția și salariul anual pentru toți angajații din același departament. */
SELECT ename,
       job,
       sal * 12 as salariu_anual,
       sal
from emp
where job = 'SALESMAN';

/* 4. Să se selecteze numele, funcția și venitul lunar pentru toți angajații care au venitul lunar mai mare de 2000.
   Venitul lunar este o funcție care are formula salariu + ifnull(comision, 0) */
SELECT ename,
       job,
       sal + ifnull(comm, 0) as salariu_lunar
from emp
where sal + ifnull(comm, 0) > 2000;

/* 5.Să se selecteze id-ul angajatului, numele, funcția și data angajării
   pentru toți angajații care au aceași funcție și au venit în firmă după o anumită dată. */
SELECT empno,
       ename,
       job,
       hiredate
from emp
where hiredate > '1981-03-30'
  and job = 'SALESMAN';


/* 6. Să se adauge 10 noi angajati. */
INSERT INTO EMP
VALUES (7935, 'JOHN', 'CLERK', 7902, '1982-12-17', 1800, 100, 10),
       (7936, 'KEN', 'CLERK', 7698, '1981-12-20', 1600, 250, 30),
       (7937, 'MATT', 'MANAGER', 7698, '1982-11-22', 2450, 500, 30),
       (7938, 'ANTHONY', 'ANALYST', 7566, '1982-12-09', 2975, NULL, 20),
       (7939, 'ANNA', 'MANAGER', 7698, '1981-09-28', 1950, 500, 30),
       (7940, 'ABBY', 'ANALYST', 7839, '1981-05-01', 2850, NULL, 30),
       (7941, 'JENNA', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10),
       (7942, 'JANE', 'ANALYST', 7566, '1982-12-09', 3000, NULL, 20),
       (7943, 'RUPERT', 'SALESMAN', 7566, '1981-11-17', 1500, 500, 10),
       (7944, 'ALEX', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30);

/* 7. Să se calculeze o primă de 15% pentru toți angajații din departamentul 20. */
update emp
set sal = ifnull(sal, 0) * 1.15
where deptno = 20;

/* 8. Să se selecteze id-ul și numele departamentului din tabela departamente. */
select deptno,
       dname
from dept;

/* 9. Să se selecteze id-ul, numele, funcția și data angajării pentru toți angajații din firmă.
   Ordonați descrescător în funcție de id. Concatenați id-ul cu numele. */
select CONCAT(empno, '_', ename) as id_name,
       job,
       hiredate
from emp
order by empno desc;

/* 10. Să se selecteze id-ul, numele, fucția și venitul lunar pentru toți angajatii din firmă.
 Să se adauge la select o coloană goală care să se numească semnătura. Concatenați id-ul cu numele. Ordonați după departament. */
select CONCAT(empno, '_', ename) as id_name,
       job,
       sal + ifnull(comm, 0)     as monthly_sal,
       ' '                       as signature
from emp
order by deptno asc;

/* 11. Să se selecteze numele și funcția angajaților. */
select ename,
       job
from emp;

/* 12. Să se facă o listă cu numele departamentului și codul acestuia. Ordonați după numele departamentului. */
-- trebuia tabel nou ? sau doar un sort normal dupa deptno, dname si sortat dupa name ?
create table newdept
(
    deptno int(2) auto_increment primary key,
    dname  varchar(14)
);
insert into newdept
select deptno,
       dname
from dept;

/* 13. Să se selecteze toți angajații care au funcția manager. Ordonați după id-ul departamentului */
select *
from emp
where job = 'MANAGER'
order by empno asc;

/* 14. Selectați toate persoanele care s-au angajat intr-o anumită perioadă aleasa de voi. */
select *
from emp
where hiredate between '1982-06-30' and '1983-12-31';

/* 15. Să se listeze id-ul, numele, funcția, venitul lunar pentru angajații care au următoarele id-uri: 7499,7902, 7876 */
select empno,
       ename,
       job,
       sal + comm as sal_lunar
from emp
where empno in (7499, 7902, 7876);

/* 16. Să se selecteze toate persoanele care au fost angajate în anul 1980 */
select *
from emp
where hiredate like '1980%';

/* 17. Să se selecteze toate persoanele al căror nume începe cu litera F și numele funcției are 7 caractere. */
select *
from emp
where ename like 'J%'
  and length(job) = 7;

/* 18. Să se listeze angajații din departamentul 20 care nu au primit comision. */
select *
from emp
where deptno = 10
  and comm is null;

/* 19. Să se listeze angajații care au primit comision și au funcția SALESMAN */
select *
from emp
where comm > 0
  and job = 'SALESMAN';

/* 20. Să se selecteze toți angajații care au funcția MANAGER și salariul peste 1500 și toți angajații care au funcția ANALYST. */
select *
from emp
where sal > 1500
  and job = 'MANAGER'
union
select *
from emp
where job = 'ANALYST';

/* 21. Selectați toți angajații care s-au angajat înainte de anul 1982 și nu au primit comision. */
select *
from emp
where hiredate < '1982-01-01'
    and comm = 0
   or comm is null;

/* 22. Selectați toți angajații care au salariul peste 3000 și nu au șefi, ordonați după departament. */
select *
from emp
where sal > 3000
  and mgr is null
order by deptno asc;

/* 23. Selectați numele, funcția și venitul anual al angajaților care nu au funcția MANAGER pentru un departament ales de voi. */
select a.ename,
       a.job,
       a.sal * 12 as a.salariu_anual,
       b.dname,
       b.city
from emp as a,
     dept b
where job != 'MANAGER'
  and a.deptno = 10
  and a.deptno = b.deptno;

/* 24. Selectați departamentul, numele, data angajării și salariul tuturor persoanelor angajate în anul 1981 din două departamente alese de voi. */
select a.deptno,
       a.ename,
       a.hiredate,
       a.sal,
       b.dname,
       b.city
from emp as a,
     dept b
where a.hiredate like '1981%'
  and a.deptno in (10, 20)
  and a.deptno = b.deptno;

-- OR

select a.deptno,
       a.ename,
       a.hiredate,
       a.sal,
       b.dname,
       b.city
from emp as a
         left join dept as b
                   on a.deptno = b.deptno
where a.hiredate like '1981%'
  and a.deptno in (10, 20);