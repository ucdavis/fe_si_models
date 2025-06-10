## Objective 
Identify different tissue fragments on a wsi and label them for inclusion or exclusion (if duplicates)

## Model type
This is not a ML-model but a rule-based model taking tissue polygons generated 
by "tissue_vs_glass" as input and outputting fragment polygons. 

![Schematic](assets/overview_si_mucosa_.png)

![Schematic](assets/legend_.png)

## Scripts
- **si_mucosa_.Rmd**
This script processes fragment and layer output to small intestinal mucosa polygons
classified by orientation
- **import_si_mucosa_.groovy** 
This script imports fragments to qupath (run for project)
- **delete_si_mucosa_.groovy** 
This script deletes annotations from qupath
- **validate_si_mucosa_**
This script assess si_mucosa performance for assessing orientation

## Development
Parameters for the model were set by testing different settings in the images 
from labl_2020 (https://github.com/ucdavis/fe_si_samples/tree/main/labl_2020) tuning set
for visual assessment.

## 2DO
- testing