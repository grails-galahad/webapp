databaseChangeLog = {

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-1") {
		createTable(tableName: "person") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "personPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "address_address1", type: "varchar(255)")

			column(name: "address_address2", type: "varchar(255)")

			column(name: "address_city", type: "varchar(255)")

			column(name: "address_postal_code", type: "varchar(255)")

			column(name: "address_state", type: "varchar(255)")

			column(name: "date_of_birth", type: "timestamp")

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "full_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bool") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-2") {
		createTable(tableName: "project") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "projectPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "owner_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-3") {
		createTable(tableName: "role") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-4") {
		createTable(tableName: "task") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "taskPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "complete", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "descr", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "due", type: "timestamp")

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "project_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-5") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-6") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-11") {
		createIndex(indexName: "authority_uniq_1373334023530", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-12") {
		createSequence(sequenceName: "hibernate_sequence")
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-7") {
		addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "project", constraintName: "FKED904B199E322026", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person", referencesUniqueColumn: "false")
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-8") {
		addForeignKeyConstraint(baseColumnNames: "project_id", baseTableName: "task", constraintName: "FK363585E6F33C66", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "project", referencesUniqueColumn: "false")
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-9") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46A8D20AC2E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "paulcitarella (generated)", id: "1373334023838-10") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A324B700E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person", referencesUniqueColumn: "false")
	}
}
