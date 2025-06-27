This folder documents development and testing of the layers model

## Model objective
Segment small intestinal layers (villi vs crypts) in feline small intestinal biopsies

## Task type
Semantic segmentation (pixel classification)

## Model architecture type & platform
CNN, Aiforia create

## Active version
fe_si_layers_pv6_mv11

## Development
This model was developed by KLJ in Aiforia and assessed by JMW

This and previous project and model versions for small intestinal layer segmentation
are documented here (sheet: fe_si_layers): 

https://docs.google.com/spreadsheets/d/1Bg5ZT4h1TjjKgKP76iZ03OzNSspau0jlSxPWKsOVVXw/edit?usp=sharing

## Tuning
- KLJ used a small set (n 21) for tuning. Most are from the labl_2020_tuning set but
some are from labl_2020_training. 
Documented here: https://drive.google.com/drive/folders/1EEyrtvhzGdj4grLw2vIOUCPeInp1xG9k?usp=sharing
- JMW did new tuning annotations in qupath, used for initial eval and setting hyperparameters.
Presented here: https://docs.google.com/presentation/d/1to3PDvGuQhchptxr13hO7236udFKBsHW1gur-ol_wyc/edit?usp=sharing

## Testing
JMW annotated test set in qupath. Each negative class annotated separately (to
allow exploration of false positives). 

