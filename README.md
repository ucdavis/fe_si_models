## Objective
This repository is a way to collect information on different AI models developed
for analyzing feline small intestinal biopsies. Each ai model has a folder, 
that for the more complex models contains it's own README on model objectives & 
intended use, links to slide decks with SOPs, info on model type and platform, 
training, tuning and testing strategies and case material used for development 
and testing.

For aiforia models, model versions and project versions are tracked here:
https://docs.google.com/spreadsheets/d/1Bg5ZT4h1TjjKgKP76iZ03OzNSspau0jlSxPWKsOVVXw/edit?usp=sharing

### Models
- *layers* (CNN, aiforia, part of combos, input for si_mucosa)
- *tissues *(CNN, aiforia, part of combos, input for artefact)
- *lymphocytes* (CNN, aiforia, part of combos, input for artefact)
- *combos* (layers, tissues and lymphocytes, chained, aiforia)
- *content_vs_background* (ruke-based, qupath, not in use)
- *tissue_vs_glass *(classic ML, qupath, input for fragments)
- *fragments* (rule-based, R, input for si_mucosa)
- *si_mucosa* (rule-based, R, input for artefact)
- *artefact* (rule-based, R)
