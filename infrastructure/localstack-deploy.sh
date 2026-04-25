#!/bin/bash

set +e

aws --endpoint-url=http://localhost:4566 cloudformation delete-stack \
    --stack-name patient-management

#aws --endpoint-url=http://localhost:4566 cloudformation wait stack-delete-complete \
#    --stack-name patient-management

aws --endpoint-url=http://localhost:4566 cloudformation deploy \
    --stack-name patient-management \
    --template-file "./cdk.out/localStack.template.json"

aws --endpoint-url=http://localhost:4566 elbv2 describe-load-balancers \
    --query "LoadBalancers[0].DNSName" --output text

aws --endpoint-url=http://localhost:4566 cloudformation describe-stack-events \
    --stack-name patient-management