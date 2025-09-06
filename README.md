# finance-track-android
this is a android project for manage personal finances. 
this app tracks profiles, debtors, loans, and payments; 
support internal movements, balance queries, and CSV export.
all using Room (SQLite) as local storage.

list of movements:
Profiles:
Debtors linked to profiles
Loans: initial amount, start date, description, status (OPEN / SETTLED / CANCELED)
Payments to loans (validation to never exceed initial amount)
Internal movements (INCOME / WITHDRAW) per profile

Balance queries:
by loan (initial − Σ payments)
by debtor (sum of open loans)
by profile (internal movements ± loans)
CSV export (loans + payments + movements)
Offline-first (no backend required)

Tech Stack
Kotlin 2.0.21
Jetpack Compose (UI)
Room (SQLite) for persistence
MVVM + Repository
Local tests with JUnit

Architecture (MVVM)
UI (Compose)  →  ViewModel  →  Repository  →  Room (DAO / Entities / DB)

UI: screens & state
ViewModel: exposes StateFlow/Flow, orchestrates use cases
Repository: business rules (e.g., payments ≤ initial, auto settle)
Room: entities, DAOs, queries & relations

🗄️ Data Model (Text ER)asi
typoEstado{ pk, nombre }
perfil { pk, nombre }
deudores{ pk,nombre }
movimientos { pk, perfil, typoEstado, cantidad, fecha, descripccion}
prestamos {pk, perfil,deudor,typoEstado, fecha, cantidad, descripcion}
pagos{pk, prestamos, cantidad, fecha}
