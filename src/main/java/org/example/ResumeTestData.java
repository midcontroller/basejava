package org.example;

import org.example.model.ContactType;
import org.example.model.AbstractContent;
import org.example.model.ListContent;
import org.example.model.Organization;
import org.example.model.OrganizationSection;
import org.example.model.Position;
import org.example.model.Resume;
import org.example.model.SectionType;
import org.example.model.TextContent;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeTestData {

	public static void main(String[] args) {
		Resume resume = createResume("UUID_1", "Григорий Кислин");
		printResume(resume);
	}

	private static Resume createResume(String uuid, String fullName) {
		return new Resume(uuid, fullName, createContacts(), createSections());
	}

	private static Map<ContactType, AbstractContent> createContacts() {
		Map<ContactType, AbstractContent> contacts = new HashMap<>();
		contacts.put(ContactType.PHONE, new TextContent("+7(921) 855-0482"));
		contacts.put(ContactType.SKYPE, new TextContent("skype:grigory.kislin"));
		contacts.put(ContactType.EMAIL, new TextContent("gkislin@yandex.ru"));
		contacts.put(ContactType.LINKEDIN, new TextContent("Профиль LinkedIn"));
		contacts.put(ContactType.GITHUB, new TextContent("Профиль GitHub"));
		contacts.put(ContactType.STACKOVERFLOW, new TextContent("Профиль StackOverflow"));
		contacts.put(ContactType.HOMEPAGE, new TextContent("Домашняя страница"));
		return contacts;
	}

	private static Map<SectionType, AbstractContent> createSections() {
		Map<SectionType, AbstractContent> sections = new HashMap<>();
		sections.put(SectionType.OBJECTIVE, new TextContent(
				"Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

		sections.put(SectionType.PERSONAL, new TextContent(
				"Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

		sections.put(SectionType.ACHIEVEMENT, new ListContent(createAchievements()));

		sections.put(SectionType.QUALIFICATIONS, new ListContent(createQualifications()));

		sections.put(SectionType.EXPERIENCE, new OrganizationSection(createExperience()));

		sections.put(SectionType.EDUCATION, new OrganizationSection(createEducation()));
		return sections;
	}

	private static List<String> createAchievements() {
		return Arrays.asList(
				"Организация команды и успешная реализация Java проектов для сторонних заказчиков приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
				"С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
				"Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
				"Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и  авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
				"Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
				"Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/Django).",
				"Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
	}

	private static List<String> createQualifications() {
		return Arrays.asList(
				"JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
				"Version control: Subversion, Git, Mercury, ClearCase, Perforce",
				"DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
				"Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
				"XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
				"Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
				"Python: Django.", "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
				"Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
				"Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
				"Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
				"администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
				"Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
				"Родной русский, английский \"upper intermediate\"");
	}

	private static List<Organization> createExperience() {
		return Arrays.asList(new Organization("Java Online Projects", "https://javaops.ru/",
				Arrays.asList(new Position(YearMonth.of(2013, 10), null, "Автор проекта",
						"Создание, организация и проведение Java онлайн проектов и стажировок."))),

				new Organization("Wrike", "https://www.wrike.com/", Arrays.asList(new Position(
						YearMonth.of(2014, 10), YearMonth.of(2016, 1),
						"Старший разработчик (backend)",
						"Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."))),

				new Organization("RIT Center", null, Arrays.asList(new Position(
						YearMonth.of(2012, 4), YearMonth.of(2014, 04), "Java архитектор",
						"Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBouncer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"))),

				new Organization("Luxoft (Deutsche Bank)", "https://career.luxoft.com/",
						Arrays.asList(new Position(YearMonth.of(2010, 12), YearMonth.of(2012, 04),
								"Ведущий программист",
								"Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."))),

				new Organization("Yota", "https://www.yota.ru/", Arrays.asList(new Position(
						YearMonth.of(2008, 06), YearMonth.of(2010, 12), "Ведущий специалист",
						"Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"))),

				new Organization("Enkata", null, Arrays.asList(new Position(YearMonth.of(2007, 03),
						YearMonth.of(2008, 06), "Разработчик ПО",
						"Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."))),

				new Organization("Siemens AG", "https://www.siemens.com/",
						Arrays.asList(new Position(YearMonth.of(2005, 01), YearMonth.of(2007, 02),
								"Разработчик ПО",
								"Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."))),

				new Organization("Alcatel", "https://www.al-enterprise.com/",
						Arrays.asList(new Position(YearMonth.of(1997, 9), YearMonth.of(2005, 01),
								"Инженер по аппаратному и программному тестированию",
								"Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."))));
	}

	private static List<Organization> createEducation() {
		return Arrays.asList(new Organization("Coursera", "https://www.coursera.org/",
				Arrays.asList(new Position(YearMonth.of(2013, 3), YearMonth.of(2013, 5),
						"'Functional Programming Principles in Scala' by Martin Odersky", null))),

				new Organization("Luxoft", "https://www.luxoft.ru/", Arrays.asList(new Position(
						YearMonth.of(2011, 3), YearMonth.of(2011, 4),
						"Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'",
						null))),

				new Organization("Siemens AG", "https://www.siemens.com/",
						Arrays.asList(new Position(YearMonth.of(2005, 1), YearMonth.of(2005, 4),
								"3 месяца обучения мобильным IN сетям (Берлин)", null))),

				new Organization("Alcatel", "https://www.al-enterprise.com/",
						Arrays.asList(new Position(YearMonth.of(1997, 9), YearMonth.of(1998, 3),
								"6 месяцев обучения цифровым телефонным сетям (Москва)", null))),

				new Organization(
						"Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
						"https://itmo.ru/", Arrays.asList(

								new Position(YearMonth.of(1993, 9), YearMonth.of(1996, 7),
										"Аспирантура (программист С, С++)", null),

								new Position(YearMonth.of(1987, 9), YearMonth.of(1993, 7),
										"Инженер (программист Fortran, C)", null))),

				new Organization("Заочная физико-техническая школа при МФТИ",
						"https://school.mipt.ru/", Arrays.asList(new Position(YearMonth.of(1984, 9),
								YearMonth.of(1987, 6), "Закончил с отличием", null))));
	}

	private static void printResume(Resume resume) {
		System.out.println(resume.getFullname() + "\n");

		for (ContactType contactType : ContactType.values()) {
			AbstractContent content = resume.getContacts().get(contactType);
			if (content != null && content instanceof TextContent textContent) {
				System.out.println(contactType.getTitle() + textContent.text());
			}
		}
		System.out.println();

		for (SectionType sectionType : SectionType.values()) {
			AbstractContent section = resume.getSections().get(sectionType);
			if (section == null)
				continue;

			System.out.println(sectionType.getTitle());

			if (section instanceof TextContent textContent) {
				System.out.println(textContent.text() + "\n");
			}

			if (section instanceof ListContent listContent) {
				for (String item : listContent.items()) {
					System.out.println("  • " + item);
				}
				System.out.println();
			}

			if (section instanceof OrganizationSection orgSection) {
				for (Organization org : orgSection.organizations()) {
					String url = org.url();
					String name = org.name();

					if (url != null) {
						System.out.println(name + " (" + url + ")");
					} else {
						System.out.println(name);
					}

					for (Position position : org.positions()) {
						String dateRange = position.startDate() + " - "
								+ (position.endDate() != null ? position.endDate() : "Сейчас");
						System.out.println("    " + dateRange);
						System.out.println("    " + position.title());

						if (position.description() != null) {
							System.out.println("    " + position.description());
						}
						System.out.println();
					}
				}
			}
		}
	}
}
