This folder documents development and testing of the layers model

## Model objective
Segment small intestinal layers (villi vs crypts) in feline small intestinal biopsies

## Task type
Semantic segmentation (pixel classification)

## Model architecture type & platform
CNN, Aiforia create

## Combination with other models in aiforia
This model was chained with the models "compartments" and "lymphocytes" within
Aiforia with layers as the parent model, "compartments" only run in recognized layers
and "lymphocytes" only run in recognized compartments. This strategy can be cost 
efficient (although the cost is not completely explainable)

SOP for combining models in aiforia:
https://docs.google.com/presentation/d/1TfTqYD7IXBNtEB0yTfHjLSWQN352mR_C/edit?usp=sharing&ouid=114290326180405247455&rtpof=true&sd=true

## Tracking of version and combinations
https://docs.google.com/spreadsheets/d/1Bg5ZT4h1TjjKgKP76iZ03OzNSspau0jlSxPWKsOVVXw/edit?usp=sharing

## Active version
fe_si_layers_pv6_mv11 in combinations fe_si_combos_pv2_mv2

## Development
This model was developed by KLJ in Aiforia and assessed by JMW


## Tuning
- KLJ used a small set (n 21) for tuning. Most are from the labl_2020_tuning set but
some are from labl_2020_training. 
Documented here: https://drive.google.com/drive/folders/1EEyrtvhzGdj4grLw2vIOUCPeInp1xG9k?usp=sharing
- JMW did new tuning annotations in qupath, used for initial eval and setting hyperparameters.
Presented here: https://docs.google.com/presentation/d/1to3PDvGuQhchptxr13hO7236udFKBsHW1gur-ol_wyc/edit?usp=sharing

## Testing
JMW annotated test set in qupath. Each negative class annotated separately (to
allow exploration of false positives). 

