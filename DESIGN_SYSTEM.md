# UnderDS — Design System Android

> Design System extraido do `app-under-android` (Under Marketplace/Delivery)

## Visao Geral

O UnderDS eh um sistema de design **light-first** com identidade visual baseada em **beige quente + ouro + branco**. Construido sobre Material3 (Jetpack Compose), com tokens customizados para cores, tipografia, espacamento e formas.

---

## Indice de Componentes

| Componente | Arquivo | Status |
|---|---|---|
| Cores (Tokens) | [tokens/UnderColors.kt](tokens/UnderColors.kt) | Documentado |
| Tipografia | [tokens/UnderTypography.kt](tokens/UnderTypography.kt) | Documentado |
| Espacamento | [tokens/UnderSpacing.kt](tokens/UnderSpacing.kt) | Documentado |
| Formas | [tokens/UnderShapes.kt](tokens/UnderShapes.kt) | Documentado |
| Tema | [tokens/UnderTheme.kt](tokens/UnderTheme.kt) | Documentado |
| DSButton | [components/DSButton.kt](components/DSButton.kt) | Documentado |
| DSTextField | [components/DSTextField.kt](components/DSTextField.kt) | Documentado |
| DSCard | [components/DSCard.kt](components/DSCard.kt) | Documentado |
| DSToolbar | [components/DSToolbar.kt](components/DSToolbar.kt) | Documentado |
| DSDialog | [components/DSDialog.kt](components/DSDialog.kt) | Documentado |
| FloatingNavBar | [components/FloatingNavBar.kt](components/FloatingNavBar.kt) | Documentado |

## Documentacao Detalhada

| Documento | Conteudo |
|---|---|
| [docs/01-cores.md](docs/01-cores.md) | Paleta de cores, semantica, mapeamento M3 |
| [docs/02-tipografia.md](docs/02-tipografia.md) | Escala tipografica, familias, pesos |
| [docs/03-espacamento.md](docs/03-espacamento.md) | Escala de espacamento, CompositionLocal |
| [docs/04-formas.md](docs/04-formas.md) | Escala de border-radius |
| [docs/05-botoes.md](docs/05-botoes.md) | DSButton — variantes, tamanhos, estados |
| [docs/06-campos-texto.md](docs/06-campos-texto.md) | DSTextField — variantes e props |
| [docs/07-cards.md](docs/07-cards.md) | DSCard — variantes e elevacao |
| [docs/08-toolbar.md](docs/08-toolbar.md) | DSToolbar — variantes e insets |
| [docs/09-dialog.md](docs/09-dialog.md) | DSDialog — variantes, halos, botoes |
| [docs/10-floating-navbar.md](docs/10-floating-navbar.md) | FloatingNavBar — navegacao flutuante |

## Regras de UX

| Regra | Arquivo |
|---|---|
| Mensagens de erro | [rules/error-messages.md](rules/error-messages.md) |
| Feedback visual | [rules/visual-feedback.md](rules/visual-feedback.md) |
| Status bar e insets | [rules/status-bar.md](rules/status-bar.md) |
