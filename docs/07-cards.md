# 07 — DSCard

## Analise UX

O DSCard encapsula os tres estilos de card usados no app. A variante **ELEVATED** (default) eh a mais comum — cards brancos com sombra sutil sobre o fundo beige, criando a sensacao de "flutuar" que define a identidade visual do app.

- **ELEVATED** → conteudo principal (pedidos, empresas, resumos)
- **OUTLINED** → conteudo secundario com borda sutil (PIX banners)
- **FILLED** → areas de fundo quente sem destaque (filtros, inputs agrupados)

---

## Variantes

| Variante | Container | Elevacao | Borda |
|---|---|---|---|
| `ELEVATED` | `surface` (white) | 2dp (default), 6dp (pressed) | nenhuma |
| `OUTLINED` | `surface` (white) | 0dp | `OutlineLight` via M3 |
| `FILLED` | `surfaceVariant` (warm) | 0dp | nenhuma |

## Props

| Prop | Tipo | Default | Descricao |
|---|---|---|---|
| `variant` | DSCardVariant | ELEVATED | Estilo visual |
| `onClick` | (() -> Unit)? | null | Callback (quando presente, card eh clicavel) |
| `content` | @Composable ColumnScope.() -> Unit | — | Conteudo do card |

---

## Uso

```kotlin
// Card elevado (padrao)
DSCard(modifier = Modifier.fillMaxWidth()) {
    Text(
        text     = "Resumo do Pedido",
        modifier = Modifier.padding(16.dp),
        style    = MaterialTheme.typography.titleMedium,
    )
}

// Card clicavel
DSCard(
    onClick = { navigateToDetail() },
    modifier = Modifier.fillMaxWidth(),
) {
    Row(modifier = Modifier.padding(16.dp)) {
        // ...conteudo
    }
}

// Card filled (sem sombra, fundo warm)
DSCard(variant = DSCardVariant.FILLED) {
    Text(
        text     = "Filtros ativos",
        modifier = Modifier.padding(12.dp),
    )
}
```
