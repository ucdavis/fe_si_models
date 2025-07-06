This folder documents development and testing of the tissue_compartment model (fe_si_tissues_pv2)

## Model objective
Segment mucosal tissue compartments (epithelium vs lamina_propria vs lumen) in feline small intestinal biopsies

## Task type
Semantic segmentation (pixel classification)

## Model architecture type & platform
CNN, Aiforia create

## Combination with other models in aiforia
This model was chained with the models "layers" and "lymphocytes" within
Aiforia with layers as the parent model, "compartments" only run in recognized layers
and "lymphocytes" only run in recognized compartments. This strategy can be cost 
efficient (although the cost is not completely explainable)

SOP for combining models in aiforia:
https://docs.google.com/presentation/d/1TfTqYD7IXBNtEB0yTfHjLSWQN352mR_C/edit?usp=sharing&ouid=114290326180405247455&rtpof=true&sd=true


## Tracking of version and combinations
https://docs.google.com/spreadsheets/d/1Bg5ZT4h1TjjKgKP76iZ03OzNSspau0jlSxPWKsOVVXw/edit?usp=sharing

## Active version
fe_si_compartments_pv2_mv1 in combinations fe_si_combos_pv2_mv2

## Development
This model was developed by JMW in Aiforia

This and previous project and model versions for small intestinal tissue compartment segmentation
are documented here: 

https://docs.google.com/spreadsheets/d/1Bg5ZT4h1TjjKgKP76iZ03OzNSspau0jlSxPWKsOVVXw/edit?usp=sharing

## Testing
Run against JMWs test annotations in aiforia

## Issues / Deviations / Comments
- Validation rois in aiforia. Aiforia does not support separate tuning and test
sets. To allow for both tuning and testing assessment in aiforia, I deleted the 
tuning rois before testing, thinking they would be retreivable from aiforia(they were
not). I later recreated them in a copy of the project **fe_si_compartments_pv4**
where they are available for download. Annotation are downloaded from there and
tests run external from aiforia (QuPath - R pipeline)


- The google sheets frame documenting project and model versions uses a naming structure
outlined here: 
https://docs.google.com/presentation/d/1Me-JiU9mieHEQjz6NjtXAcWRx75MmnYM/edit?usp=sharing&ouid=114290326180405247455&rtpof=true&sd=true

